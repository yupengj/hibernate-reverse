package com.gantang.generatecode.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gantang.generatecode.dto.MetadataModel;

public class MetadataMapping implements RowMapper<MetadataModel> {

	@Override
	public MetadataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		MetadataModel metadata = new MetadataModel();
		metadata.setSchemaName(rs.getString("schemaName"));
		metadata.setTableName(rs.getString("tableName"));
		metadata.setColumnName(rs.getString("columnName"));
		metadata.setColumnType(rs.getString("columnType"));
		try {
			metadata.setComments(rs.getString("comments"));
			metadata.setDataLength(rs.getInt("dataLength"));
			metadata.setDataPrecision(rs.getInt("dataPrecision"));
			metadata.setDataScale(rs.getInt("dataScale"));
			metadata.setNullable(rs.getBoolean("nullable"));
		} catch (Exception e) {
			
		}
		return metadata;
	}
}
