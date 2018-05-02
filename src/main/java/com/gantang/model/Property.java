
package com.gantang.model;

public class Property {
	private String name;
	private String cloumnName;
	private String type;
	private Integer length = 255;
	private Integer precision;
	private Integer scale;
	private String isNull;

	public Property(String cloumnName, String type, Integer length, Integer precision, Integer scale, String isNull) {
		super();
		this.cloumnName = cloumnName;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "Property [name=" + name + ", cloumnName=" + cloumnName + ", type=" + type + ", length=" + length + ", precision=" + precision + ", scale="
				+ scale + ", isNull=" + isNull + "]";
	}

}
