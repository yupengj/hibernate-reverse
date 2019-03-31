package com.gantang.generatecode.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.gantang.generatecode.dto.GenerateBean;
import com.gantang.generatecode.dto.GenerateConfig;
import com.gantang.generatecode.dto.GenerateProperty;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public interface GenerateCodeService {

	final Logger log = LoggerFactory.getLogger(GenerateCodeService.class);

	final static String RUNTIME_BY_JAR = "runtimeByJar";

	final static String FILE_RESOURCE_LOADER_CLASS_KEY = "file.resource.loader.class";

	final static String FILE_RESOURCE_LOADER_CLASS_VALUE = "org.apache.velocity.runtime.resource.loader.JarResourceLoader";

	final static String TEMPLATE_PATH = "codes";

	final static String JAR_TEMPLATE_PATH = "BOOT-INF/classes/" + TEMPLATE_PATH;

	/**
	 * 
	 * @param beans          要生成代码的表及表结构
	 * @param generateConfig 生成代码的配置
	 */
	default void generateCode(VelocityEngine velocityEngine, List<GenerateBean> beans, GenerateConfig generateConfig) {
		for (GenerateBean bean : beans) {
			bean.setAuthor(generateConfig.getAuthor());
			for (String tempName : reverseModel(generateConfig)) {
				setBeanPackage(bean, generateConfig, tempName);
				setCodePath(bean, generateConfig, tempName);

				String code = createCode(velocityEngine, tempName + ".vm", bean, bean.getProperties());
				writeCodeToFile(createFile(bean.getCodePath()), code);
			}
		}
	}

	/**
	 * 生成代码
	 * 
	 * @param tempName  模板名称
	 * @param bean      bean
	 * @param propertys bean 的属性对象
	 * @return 代码
	 */
	default String createCode(VelocityEngine velocityEngine, String tempName, GenerateBean bean, List<GenerateProperty> propertys) {
		String templatePath = velocityEngine.getProperty(RUNTIME_BY_JAR) == null ? TEMPLATE_PATH : JAR_TEMPLATE_PATH;
		templatePath += "/" + getTempType() + "/" + tempName;
		Template template = velocityEngine.getTemplate(templatePath);

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("bean", bean);
		velocityContext.put("propertyList", propertys);

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		String code = stringWriter.toString();
		return code;
	}

	default VelocityEngine initVelocityEngine() {
		Properties properties = new Properties();
		URL url = getClass().getResource("/");
		String resourcePath = url.getPath();
		log.info("当前程序运行路径 : " + resourcePath);
		if (ResourceUtils.isJarURL(url)) {
			resourcePath = "jar:" + resourcePath.substring(0, resourcePath.indexOf(".jar") + 4);
			properties.setProperty(RUNTIME_BY_JAR, Boolean.TRUE.toString());
			properties.setProperty(FILE_RESOURCE_LOADER_CLASS_KEY, FILE_RESOURCE_LOADER_CLASS_VALUE);
		}

		log.info("代码模板路径 : " + resourcePath);
		properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, resourcePath);

		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init(properties);
		log.info("加载资源类 : " + velocityEngine.getProperty(FILE_RESOURCE_LOADER_CLASS_KEY));
		return velocityEngine;
	}

	/**
	 * 
	 * @param path path
	 * @return File
	 */
	default File createFile(String path) {
		File file = new File(path);
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 生成 code 文件
	 * 
	 * @param file code 文件
	 * @param code code
	 */
	default void writeCodeToFile(File file, String code) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(code);
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @param config 生成代码的配置
	 * @return 模板名称
	 */
	String[] reverseModel(GenerateConfig config);

	/**
	 * 
	 * @param bean     bean
	 * @param config   生成代码的配置
	 * @param tempName 模板名称
	 */
	void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName);

	/**
	 * 
	 * @param bean     bean
	 * @param config   生成代码的配置
	 * @param tempName 模板名称
	 */
	void setCodePath(GenerateBean bean, GenerateConfig config, String tempName);

	/**
	 * 
	 * @return 模板名称
	 */
	String getTempType();
}
