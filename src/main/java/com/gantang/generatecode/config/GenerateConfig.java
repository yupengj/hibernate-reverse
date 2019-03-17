package com.gantang.generatecode.config;

import java.util.Set;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public final class GenerateConfig {

	private static final String AUTHOR = "author";
	private static final String ROOT_PACKAGE = "rootPackage";
	private static final String JS_ROOT_PACKAGE = "jsRootPackage";
	private static final String BEFORE_SCHEMA_NAME = "beforeSchemaName";
	private static final String AFTER_SCHEMA_NAME = "afterSchemaName";
	private static final String JAVA_CODE = "javaCode";
	private static final String JS_CODE = "jsTCode";

	private static GenerateConfig GENERATE_CONFIG = new GenerateConfig();

	private String jsRootPackage;
	private String author;
	private String rootPackage;
	private String beforeSchemaName;
	private String afterSchemaName;
	private Set<String> reverseJavaTempName;
	private Set<String> reverseJsTempName;

	private GenerateConfig() {
		this.author = Config.getValue(AUTHOR);
		this.rootPackage = Config.getValue(ROOT_PACKAGE);
		this.jsRootPackage = Config.getValue(JS_ROOT_PACKAGE);
		this.beforeSchemaName = Config.getValue(BEFORE_SCHEMA_NAME);
		this.afterSchemaName = Config.getValue(AFTER_SCHEMA_NAME);
		this.reverseJavaTempName = Config.getSetValue(JAVA_CODE);
		this.reverseJsTempName = Config.getSetValue(JS_CODE);
	}

	/**
	 * 创建 GenerateConfig
	 * 
	 * @return GenerateConfig
	 */
	public static GenerateConfig newInstance() {
		return GENERATE_CONFIG;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getJsRootPackage() {
		return jsRootPackage;
	}

	public void setJsRootPackage(String jsRootPackage) {
		this.jsRootPackage = jsRootPackage;
	}

	public String getRootPackage() {
		return rootPackage;
	}

	public void setRootPackage(String rootPackage) {
		this.rootPackage = rootPackage;
	}

	public String getBeforeSchemaName() {
		return beforeSchemaName;
	}

	public void setBeforeSchemaName(String beforeSchemaName) {
		this.beforeSchemaName = beforeSchemaName;
	}

	public String getAfterSchemaName() {
		return afterSchemaName;
	}

	public void setAfterSchemaName(String afterSchemaName) {
		this.afterSchemaName = afterSchemaName;
	}

	public Set<String> getReverseJavaTempName() {
		return reverseJavaTempName;
	}

	public void setReverseJavaTempName(Set<String> reverseJavaTempName) {
		this.reverseJavaTempName = reverseJavaTempName;
	}

	public Set<String> getReverseJsTempName() {
		return reverseJsTempName;
	}

	public void setReverseJsTempName(Set<String> reverseJsTempName) {
		this.reverseJsTempName = reverseJsTempName;
	}

}
