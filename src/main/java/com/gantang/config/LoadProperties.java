/**
 * 
 */
package com.gantang.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.CodeGenerate;

public class LoadProperties {

	Logger log = LoggerFactory.getLogger(CodeGenerate.class);

	private Properties prop = new Properties();

	public LoadProperties(String propertiesName) {
		prop = loadProperty(propertiesName);
	}

	public Properties loadProperty(String propertiesName) {
		try {
			if (propertiesName != null || !"".equals(propertiesName)) {
				InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream(propertiesName);
				if (is == null) {
					is = LoadProperties.class.getClassLoader().getResourceAsStream("/" + propertiesName);
				}
				prop.load(is);
				is.close();
				log.info("......");
			}
		} catch (IOException e) {
			log.error("......");
			e.printStackTrace();
		}
		return prop;
	}

	public String getValue(String key, String defaultv) {
		return prop.getProperty(key, defaultv);
	}

	public String getValue(String key) {
		return prop.getProperty(key);
	}

}
