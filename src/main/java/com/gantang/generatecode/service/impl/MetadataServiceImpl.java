package com.gantang.generatecode.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gantang.generatecode.dao.MetadataDao;
import com.gantang.generatecode.dto.GenerateBean;
import com.gantang.generatecode.dto.GenerateProperty;
import com.gantang.generatecode.dto.MetadataModel;
import com.gantang.generatecode.service.MetadataService;

@Service("metadataService")
public class MetadataServiceImpl implements MetadataService {

	@Autowired
	MetadataDao metadataDao;

	@Override
	public List<String> findAllTable(String tableName) {
		if (tableName != null) {
			tableName = tableName.trim();
		}
		return metadataDao.findAllTable(tableName);
	}

	@Override
	public List<GenerateBean> loadGenerateBean(String[] tablesNames) {
		List<MetadataModel> metadataModels = metadataDao.findMetadataModel(tablesNames);
		return loadGenerateBean(metadataModels);
	}

	private List<GenerateBean> loadGenerateBean(List<MetadataModel> metadataModels) {
		List<GenerateBean> beans = new ArrayList<>();

		Map<String, List<MetadataModel>> bean2Propertys = metadataModels.stream()
				.collect(Collectors.groupingBy(it -> it.getSchemaName() + "@" + it.getTableName()));

		for (Entry<String, List<MetadataModel>> entry : bean2Propertys.entrySet()) {
			String schemaName = entry.getKey().split("@")[0];
			String tableName = entry.getKey().split("@")[1];
			GenerateBean bean = new GenerateBean(tableName, schemaName, loadProperty(entry.getValue(), tableName));
			beans.add(bean);
		}
		return beans;
	}

	private List<GenerateProperty> loadProperty(List<MetadataModel> metadataModels, String tableName) {
		List<GenerateProperty> propertys = new ArrayList<>();
		List<String> filterNames = filterPropertyName();
		for (MetadataModel metadataModel : metadataModels) {
			String cloumnName = metadataModel.getColumnName();
			String name = handlePropertyName(cloumnName, tableName);
			if (filterNames.contains(name)) {
				continue;
			}
			GenerateProperty property = new GenerateProperty(name, cloumnName, metadataModel.getComments(), metadataModel.getColumnType(),
					metadataModel.getDataLength(), metadataModel.getDataPrecision(), metadataModel.getDataScale(),
					metadataModel.getNullable() == null ? null : metadataModel.getNullable().toString());
			propertys.add(property);
		}
		return propertys;
	}

	private List<String> filterPropertyName() {
		String[] filterNames = { "id", "createdBy", "createDate", "updatedBy", "updateDate", "isDeleted", "deleteDate", "deletedBy", "optCounter" };
		return Arrays.asList(filterNames);
	}

	private String handlePropertyName(String cloumnName, String tableName) {
		if (cloumnName.toUpperCase().equals((tableName + "_ID").toUpperCase())) {
			return "id";
		}
		if (cloumnName.contains("_")) {
			cloumnName = cloumnName.toUpperCase();
			String[] array = cloumnName.split("_");
			String name = array[0].toLowerCase();
			for (int i = 1; i < array.length; i++) {
				// 第一个元素去掉,因为第一个是 MD_ 或其他
				String str = array[i];
				name = name + str.substring(0, 1) + str.substring(1).toLowerCase();
			}
			return name;
		} else {
			return cloumnName.toLowerCase();
		}
	}

}
