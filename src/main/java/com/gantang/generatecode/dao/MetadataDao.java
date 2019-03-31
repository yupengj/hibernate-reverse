package com.gantang.generatecode.dao;

import java.util.List;

import com.gantang.generatecode.dto.MetadataModel;

public interface MetadataDao {

	List<String> findAllTable(String tableName);

	List<MetadataModel> findMetadataModel(String[] tables);

}
