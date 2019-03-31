package com.gantang.generatecode.service;

import java.util.List;

import com.gantang.generatecode.dto.GenerateBean;

public interface MetadataService {

	List<GenerateBean> loadGenerateBean(String[] tablesNames);

	List<String> findAllTable(String tableName);

}
