package com.gantang.generatecode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jiangyp
 *
 */
public class GenerateBean {

	/**
	 * bean的名称
	 */
	private String beanName;
	/**
	 * 数据库表名
	 */
	private String tableName;
	private String nameVariable;
	private String schemaName;
	private String schemaNameLowerCase;
	private String beanPackagePrefix;
	private String beanPackage;
	private List<GenerateProperty> properties = new ArrayList<>();

	public GenerateBean(String beanName, String tableName, String schemaName, List<GenerateProperty> properties) {
		super();
		this.beanName = beanName;
		this.nameVariable = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
		this.tableName = tableName;
		this.schemaName = schemaName;
		this.schemaNameLowerCase = schemaName.toLowerCase();
		this.properties = properties;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getNameVariable() {
		return nameVariable;
	}

	public void setNameVariable(String nameVariable) {
		this.nameVariable = nameVariable;
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

	public String getSchemaNameLowerCase() {
		return schemaNameLowerCase;
	}

	public void setSchemaNameLowerCase(String schemaNameLowerCase) {
		this.schemaNameLowerCase = schemaNameLowerCase;
	}

	public String getBeanPackagePrefix() {
		return beanPackagePrefix;
	}

	public void setBeanPackagePrefix(String beanPackagePrefix) {
		this.beanPackagePrefix = beanPackagePrefix;
	}

	public String getBeanPackage() {
		return beanPackage;
	}

	public void setBeanPackage(String beanPackage) {
		this.beanPackage = beanPackage;
	}

	public List<GenerateProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GenerateProperty> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "GenerateBean [beanName=" + beanName + ", tableName=" + tableName + ", nameVariable=" + nameVariable + ", schemaName=" + schemaName
				+ ", schemaNameLowerCase=" + schemaNameLowerCase + ", beanPackagePrefix=" + beanPackagePrefix + ", beanPackage=" + beanPackage + ", properties="
				+ properties + "]";
	}

}
