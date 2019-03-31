package com.gantang.generatecode.dto;

/**
 * 与数据库交互对象
 * 
 * @author jyp10@foxmail.com
 *
 */
public class MetadataModel {
	private String schemaName;
	private String tableName;
	private String columnName;
	private String columnType;
	private String comments;
	private Integer dataLength;
	private Integer dataPrecision;
	private Integer dataScale;
	private Boolean nullable;

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getDataLength() {
		return dataLength;
	}

	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}

	public Integer getDataPrecision() {
		return dataPrecision;
	}

	public void setDataPrecision(Integer dataPrecision) {
		this.dataPrecision = dataPrecision;
	}

	public Integer getDataScale() {
		return dataScale;
	}

	public void setDataScale(Integer dataScale) {
		this.dataScale = dataScale;
	}

	public Boolean getNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	@Override
	public String toString() {
		return "MetadataModel [schemaName=" + schemaName + ", tableName=" + tableName + ", columnName=" + columnName + ", columnType=" + columnType
				+ ", comments=" + comments + ", dataLength=" + dataLength + ", dataPrecision=" + dataPrecision + ", dataScale=" + dataScale + ", nullable="
				+ nullable + "]";
	}

}
