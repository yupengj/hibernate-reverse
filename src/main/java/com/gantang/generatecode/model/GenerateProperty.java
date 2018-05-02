
package com.gantang.generatecode.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jiangyp
 *
 */
public class GenerateProperty {

	private static Map<String, String> TYPE_MAPPING = new HashMap<>();
	private static Map<String, String> JS_TYPE_MAPPING = new HashMap<>();
	static {
		TYPE_MAPPING.put("VARCHAR2", "String");
		TYPE_MAPPING.put("NVARCHAR2", "String");
		TYPE_MAPPING.put("CHAR", "Boolean");
		TYPE_MAPPING.put("NUMBER", "Long");
		TYPE_MAPPING.put("DATE", "Date");

		JS_TYPE_MAPPING.put("VARCHAR2", "string");
		JS_TYPE_MAPPING.put("NVARCHAR2", "string");
		JS_TYPE_MAPPING.put("CHAR", "boolean");
		JS_TYPE_MAPPING.put("NUMBER", "number");
		JS_TYPE_MAPPING.put("DATE", "date");
	}

	private String name;
	private String cloumnName;
	private String methodName;
	private String type;
	private String jsType;
	private Integer length = 255;
	private Integer precision;
	private Integer scale;
	private String isNull;

	public GenerateProperty(String name, String cloumnName, String type, Integer length, Integer precision, Integer scale, String isNull) {
		super();
		this.name = name;
		this.methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.cloumnName = cloumnName;
		this.type = TYPE_MAPPING.get(type);
		this.jsType = JS_TYPE_MAPPING.get(type);
		this.length = length;
		this.precision = precision;
		this.scale = scale;
		this.isNull = isNull;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCloumnName() {
		return cloumnName;
	}

	public void setCloumnName(String cloumnName) {
		this.cloumnName = cloumnName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJsType() {
		return jsType;
	}

	public void setJsType(String jsType) {
		this.jsType = jsType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	@Override
	public String toString() {
		return "Property [name=" + name + ", cloumnName=" + cloumnName + ", methodName=" + methodName + ", type=" + type + ", length=" + length + ", precision="
				+ precision + ", scale=" + scale + ", isNull=" + isNull + "]";
	}

}
