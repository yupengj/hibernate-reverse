package com.gantang.generatecode.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class Config {

	private static String CONFIG_PATH = "/config.properties";

	private static Properties properties;

	static {
		properties = loadConfig();
	}

	private Config() {
	}

	private static Properties loadConfig() {
		InputStream insss = Object.class.getResourceAsStream(CONFIG_PATH);
		Properties pss = new Properties();
		try {
			pss.load(insss);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pss;
	}

	public static String getValue(String key) {
		if (key == null) {
			return null;
		}
		Object value = properties.getProperty(key);
		if (value == null) {
			return null;
		}
		return value.toString();
	}

	public static Set<String> getSetValue(String key) {
		String value = getValue(key);
		if (value == null) {
			return null;
		}

		Set<String> values = Stream.of(value.split(",")).filter(it -> StringUtils.isNoneEmpty(it)).collect(Collectors.toSet());
		if (values.isEmpty()) {
			return null;
		}
		return values;
	}

	public static String codeRootPath() {
		return System.getProperty("user.dir") + "\\codes\\";
	}
}
