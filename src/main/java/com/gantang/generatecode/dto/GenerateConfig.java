package com.gantang.generatecode.dto;

import java.util.stream.Stream;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class GenerateConfig {

	private String author;
	private String javaRootPackage;
	private String jsRootPackage;
	private String prefixPackage;
	private String suffixPackage;
	private String javaModels;
	private String jsModels;
	private String tableNames;
	private String outPath;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getJavaRootPackage() {
		return javaRootPackage;
	}

	public void setJavaRootPackage(String javaRootPackage) {
		this.javaRootPackage = javaRootPackage;
	}

	public String getJsRootPackage() {
		return jsRootPackage;
	}

	public void setJsRootPackage(String jsRootPackage) {
		this.jsRootPackage = jsRootPackage;
	}

	public String getPrefixPackage() {
		return prefixPackage;
	}

	public void setPrefixPackage(String prefixPackage) {
		this.prefixPackage = prefixPackage;
	}

	public String getSuffixPackage() {
		return suffixPackage;
	}

	public void setSuffixPackage(String suffixPackage) {
		this.suffixPackage = suffixPackage;
	}

	public String[] getJavaModels() {
		return stringToArray(javaModels);
	}

	public void setJavaModels(String javaModels) {
		this.javaModels = javaModels;
	}

	public String[] getJsModels() {
		return stringToArray(jsModels);
	}

	public void setJsModels(String jsModels) {
		this.jsModels = jsModels;
	}

	public String[] getTableNames() {
		return stringToArray(tableNames);
	}

	public void setTableNames(String tableNames) {
		this.tableNames = tableNames;
	}

	public String getOutPath() {
		return outPath == null ? "D:\\generateCode\\" : outPath;
	}

	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}

	public String[] stringToArray(String string) {
		if (string == null) {
			return new String[0];
		}
		String[] array = Stream.of(string).flatMap(it -> Stream.of(it.split(","))).distinct().filter(it -> it != null && !it.equals("")).toArray(String[]::new);
		return array;
	}

	@Override
	public String toString() {
		return "GenerateConfig [author=" + author + ", javaRootPackage=" + javaRootPackage + ", jsRootPackage=" + jsRootPackage + ", prefixPackage="
				+ prefixPackage + ", suffixPackage=" + suffixPackage + ", javaModels=" + javaModels + ", jsModels=" + jsModels + ", tableNames=" + tableNames
				+ ", outPath=" + outPath + "]";
	}

}
