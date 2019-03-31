package com.gantang.generatecode.dto;

import java.util.HashMap;
import java.util.Map;

import com.gantang.generatecode.utils.DbUtils;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class PropertyTypeMapping {
	private static Map<String, String> TYPE_MAPPING_ORACLE = new HashMap<>();
	private static Map<String, String> JS_TYPE_MAPPING_ORACLE = new HashMap<>();
	static {
		TYPE_MAPPING_ORACLE.put("VARCHAR2", "String");
		TYPE_MAPPING_ORACLE.put("NVARCHAR2", "String");
		TYPE_MAPPING_ORACLE.put("CHAR", "Boolean");
		TYPE_MAPPING_ORACLE.put("NUMBER", "Long");
		TYPE_MAPPING_ORACLE.put("DATE", "Date");

		JS_TYPE_MAPPING_ORACLE.put("VARCHAR2", "string");
		JS_TYPE_MAPPING_ORACLE.put("NVARCHAR2", "string");
		JS_TYPE_MAPPING_ORACLE.put("CHAR", "boolean");
		JS_TYPE_MAPPING_ORACLE.put("NUMBER", "number");
		JS_TYPE_MAPPING_ORACLE.put("DATE", "date");
	}

	private static Map<String, String> TYPE_MAPPING_PG = new HashMap<>();
	private static Map<String, String> JS_TYPE_MAPPING_PG = new HashMap<>();
	static {
		TYPE_MAPPING_PG.put("text", "String");
		TYPE_MAPPING_PG.put("boolean", "Boolean");
		TYPE_MAPPING_PG.put("bigint", "Long");
		TYPE_MAPPING_PG.put("double precision", "Double");
		TYPE_MAPPING_PG.put("numeric", "Double");
		TYPE_MAPPING_PG.put("timestamp without time zone", "Date");

		JS_TYPE_MAPPING_PG.put("text", "string");
		JS_TYPE_MAPPING_PG.put("boolean", "boolean");
		JS_TYPE_MAPPING_PG.put("bigint", "number");
		JS_TYPE_MAPPING_PG.put("double precision", "number");
		JS_TYPE_MAPPING_PG.put("numeric", "number");
		JS_TYPE_MAPPING_PG.put("timestamp without time zone", "date");
	}

	public static String getJsTypeMapping(String key) {
		if (DbUtils.isOracle()) {
			return JS_TYPE_MAPPING_ORACLE.get(key);
		} else if (DbUtils.isPgSql()) {
			return JS_TYPE_MAPPING_PG.get(convertKey(key));
		}
		return null;
	}

	public static String getJavaTypeMapping(String key) {
		if (DbUtils.isOracle()) {
			return TYPE_MAPPING_ORACLE.get(key);
		} else if (DbUtils.isPgSql()) {
			return TYPE_MAPPING_PG.get(convertKey(key));
		}
		return null;
	}

	private static String convertKey(String key) {
		return key.startsWith("numeric") ? "numeric" : key;
	}
}
