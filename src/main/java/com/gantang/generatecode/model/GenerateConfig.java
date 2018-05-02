package com.gantang.generatecode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jiangyp
 *
 */
public class GenerateConfig {

	private String beforeSchemaName;
	private String afterSchemaName;
	private String annotationAuthorName;
	private List<String> reverseJavaTempName = new ArrayList<>();
	private List<String> reverseJsTempName = new ArrayList<>();
	private List<String> reverseTableName = new ArrayList<>();

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

	public List<String> getReverseTableName() {
		return reverseTableName;
	}

	public void setReverseTableName(List<String> reverseTableName) {
		this.reverseTableName = reverseTableName;
	}

	public List<String> getReverseJavaTempName() {
		return reverseJavaTempName;
	}

	public void setReverseJavaTempName(List<String> reverseJavaTempName) {
		this.reverseJavaTempName = reverseJavaTempName;
	}

	public List<String> getReverseJsTempName() {
		return reverseJsTempName;
	}

	public void setReverseJsTempName(List<String> reverseJsTempName) {
		this.reverseJsTempName = reverseJsTempName;
	}

	public String getAnnotationAuthorName() {
		return annotationAuthorName;
	}

	public void setAnnotationAuthorName(String annotationAuthorName) {
		this.annotationAuthorName = annotationAuthorName;
	}

	@Override
	public String toString() {
		return "GenerateConfig [beforeSchemaName=" + beforeSchemaName + ", afterSchemaName=" + afterSchemaName + ", annotationAuthorName="
				+ annotationAuthorName + ", reverseJavaTempName=" + reverseJavaTempName + ", reverseJsTempName=" + reverseJsTempName + ", reverseTableName="
				+ reverseTableName + "]";
	}

}
