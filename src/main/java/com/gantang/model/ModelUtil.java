package com.gantang.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.gantang.config.LoadProperties;
import com.gantang.db.TableUtil;

public class ModelUtil {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private static final String CONFIG_FIEL = "bean.cfg.properties";
	private static LoadProperties config = new LoadProperties(CONFIG_FIEL);

	private static final String annotation_author_name = "annotation_author_name";

	private TableUtil tableUtil = new TableUtil();

	public List<Bean> loadBean() {
		List<Bean> beans = new ArrayList<>();
		List<Object[]> tableDesc = tableUtil.selectTableDesc();
		Map<String, List<Object[]>> bean2Propertys = tableDesc.stream().collect(Collectors.groupingBy(objs -> objs[0] + "@" + objs[1]));
		for (Entry<String, List<Object[]>> entry : bean2Propertys.entrySet()) {
			String tableName = entry.getKey().split("@")[1];
			String schemaName = entry.getKey().split("@")[0];
			Bean bean = new Bean(handleBeanName(tableName), tableName, schemaName, loadProperty(entry.getValue()));
			beans.add(bean);
		}
		return beans;
	}

	public List<Property> loadProperty(List<Object[]> objects) {
		List<Property> propertys = new ArrayList<>();
		for (Object[] obj : objects) {
			Integer length = obj[4] == null ? null : ((BigDecimal) obj[4]).intValue();
			Integer precision = obj[5] == null ? null : ((BigDecimal) obj[5]).intValue();
			Integer scale = obj[6] == null ? null : ((BigDecimal) obj[6]).intValue();
			Property property = new Property((String) obj[2], (String) obj[3], length, precision, scale, (String) obj[7]);
			propertys.add(property);
		}
		return propertys;
	}

	protected String handleBeanName(String tableName) {
		if (tableName.contains("_")) {
			String[] array = tableName.split("_");
			String beanName = "";
			for (int i = 1; i < array.length; i++) {
				// 第一个元素去掉
				String str = array[i];
				beanName = beanName + str.substring(0, 1) + str.substring(1).toLowerCase();
			}
			return beanName;
		} else {
			return tableName.substring(0, 1) + tableName.substring(1).toLowerCase();
		}
	}

	public Annotation loadAnnotation() {
		return new Annotation(config.getValue(annotation_author_name), sdf.format(new Date()));
	}
}
