
package com.gantang.generatecode.dto;

/**
 * 与模板交互对象
 * 
 * @author jiangyp
 *
 */
public class GenerateProperty {

	private String name;
	private String cloumnName;
	private String cloumnDesc;
	private String methodName;
	private String type;
	private String jsType;
	private Integer length = 255;
	private Integer precision;
	private Integer scale;
	private String isNull;

	public GenerateProperty(String name, String cloumnName, String cloumnDesc, String type, Integer length, Integer precision, Integer scale, String isNull) {
		super();
		this.name = name;
		this.methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.cloumnName = cloumnName;
		this.cloumnDesc = cloumnDesc;
		this.type = PropertyTypeMapping.getJavaTypeMapping(type);
		this.jsType = PropertyTypeMapping.getJsTypeMapping(type);
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

	public String getCloumnDesc() {
		return cloumnDesc;
	}

	public void setCloumnDesc(String cloumnDesc) {
		this.cloumnDesc = cloumnDesc;
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
		return "GenerateProperty [name=" + name + ", cloumnName=" + cloumnName + ", cloumnDesc=" + cloumnDesc + ", methodName=" + methodName + ", type=" + type
				+ ", jsType=" + jsType + ", length=" + length + ", precision=" + precision + ", scale=" + scale + ", isNull=" + isNull + "]";
	}

}
