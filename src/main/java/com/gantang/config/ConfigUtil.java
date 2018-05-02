package com.gantang.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigUtil {

	private static final String CONFIG_FIEL = "bean.cfg.properties";

	private static LoadProperties config = new LoadProperties(CONFIG_FIEL);

	private static final String root_url = "root_url";

	private static final String root_package = "root_package";

	private static final String reverse_schema_name = "reverse_schema_name";

	private static final String reverse_table_name = "reverse_table_name";

	private static final String reverse_java_temp_name = "reverse_java_temp_name";

	private static final String reverse_js_temp_name = "reverse_js_temp_name";

	private static final String not_reverse_table_name = "not_reverse_table_name";

	public static String getRootUrl() {
		String url = config.getValue(root_url);
		if (url == null || url.equals("")) {
			url = "src.java";
		}
		return url.trim();
	}

	public static String getRootPackage() {
		String url = config.getValue(root_package);
		if (url == null || url.equals("")) {
			url = "com";
		}
		return url.trim();
	}

	public static List<String> getSchemaName() {
		return getListValue(reverse_schema_name);
	}

	public static List<String> getTableName() {
		return getListValue(reverse_table_name);
	}

	public static List<String> getNotTableName() {
		return getListValue(not_reverse_table_name);
	}

	public static List<String> getJavaTempName() {
		return getListValue(reverse_java_temp_name);
	}

	public static List<String> getJsTempName() {
		return getListValue(reverse_js_temp_name);
	}

	private static List<String> getListValue(String key) {
		List<String> listValues = new ArrayList<>();
		String values = config.getValue(key);
		if (values != null && !values.equals("")) {
			listValues = Arrays.asList(values.trim().split(" "));
		}
		return listValues;
	}

}
