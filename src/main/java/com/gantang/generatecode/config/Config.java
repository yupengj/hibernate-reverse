package com.gantang.generatecode.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public final class Config {

	private static String CONFIG_PATH = "/config.properties";

	private static Properties PROPERTIES;

	static {
		PROPERTIES = loadConfig();
	}

	private Config() {
	}

	/**
	 * 加载配置文件
	 * 
	 * @return Properties
	 */
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

	/**
	 * 根据 key 得到 value
	 * 
	 * @param key key
	 * @return value
	 */
	public static String getValue(String key) {
		if (key == null) {
			return null;
		}
		Object value = PROPERTIES.getProperty(key);
		if (value == null) {
			return null;
		}
		return value.toString();
	}

	/**
	 * 得到 set 集合配置
	 * 
	 * @param key key
	 * @return set 集合 value
	 */
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

	/**
	 * 生成代码文件的位置
	 * 
	 * @return 文件路径
	 */
	public static String generateCodePath() {
		return getValue("outPath") == null ? "D:/generateCode/" : getValue("outPath");
	}
}
