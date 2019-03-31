package com.gantang.generatecode.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 与模板交互对象
 * 
 * @author jiangyp
 *
 */
public class GenerateBean {

	private String author;

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

	private String codePath;

	public GenerateBean(String tableName, String schemaName, List<GenerateProperty> properties) {
		super();
		this.beanName = handleBeanName(tableName);
		this.nameVariable = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
		this.tableName = tableName;
		this.schemaName = schemaName;
		this.schemaNameLowerCase = schemaName.toLowerCase();
		this.properties = properties;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getCodePath() {
		return codePath;
	}

	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}

	/**
	 * 把 表名转换成类名
	 * 
	 * @param tableName 表名
	 * @return 类名集合
	 */
	private String handleBeanName(String tableName) {
		if (tableName.contains("_")) {
			String[] array = tableName.split("_");
			String beanName = "";
			for (int i = 1; i < array.length; i++) {
				// 第一个元素去掉
				String str = array[i];
				beanName = beanName + str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
			}
			return beanName;
		} else {
			return tableName.substring(0, 1).toUpperCase() + tableName.substring(1).toLowerCase();
		}
	}

	@Override
	public String toString() {
		return "GenerateBean [author=" + author + ", beanName=" + beanName + ", tableName=" + tableName + ", nameVariable=" + nameVariable + ", schemaName="
				+ schemaName + ", schemaNameLowerCase=" + schemaNameLowerCase + ", beanPackagePrefix=" + beanPackagePrefix + ", beanPackage=" + beanPackage
				+ ", properties=" + properties + ", codePath=" + codePath + "]";
	}

}
