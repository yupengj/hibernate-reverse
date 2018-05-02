package com.gantang.model;

import java.util.ArrayList;
import java.util.List;

public class Bean {

	/**
	 * bean的名称
	 */
	private String beanName;
	/**
	 * 数据库表名
	 */
	private String tableName;
	private String schemaName;
	private String beanUrl;

	private List<Property> properties = new ArrayList<>();

	public Bean(String beanName, String tableName, String schemaName, List<Property> properties) {
		super();
		this.beanName = beanName;
		this.tableName = tableName;
		this.schemaName = schemaName;
		this.properties = properties;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getBeanUrl() {
		return beanUrl;
	}

	public void setBeanUrl(String beanUrl) {
		this.beanUrl = beanUrl;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Bean [beanName=" + beanName + ", tableName=" + tableName + ", schemaName=" + schemaName + ", properties=" + properties + "]";
	}

}
