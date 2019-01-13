package com.gantang.generatecode.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.gantang.generatecode.config.GenerateConfig;
import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateProperty;

public interface GenerateCodeService {

	default void generateCode(List<GenerateBean> beans, GenerateConfig generateConfig) {
		for (GenerateBean bean : beans) {
			bean.setAuthor(generateConfig.getAuthor());
			generateCode(generateConfig, bean);
		}
	}

	/**
	 * 生成代码
	 * 
	 * @param bean             bean
	 * @param annotationAuthor annotationAuthor
	 * @param config           配置信息
	 */
	default void generateCode(GenerateConfig config, GenerateBean bean) {
		Set<String> reverseTempNames = reverseTempNames(config);
		if (reverseTempNames == null) {
			return;
		}
		for (String tempName : reverseTempNames) {
			setBeanPackage(bean, config, tempName);
			setCodePath(bean, config, tempName);

			String code = createCode(tempName + ".vm", bean, bean.getProperties());
			writeCodeToFile(createFile(bean.getCodePath()), code);
		}
	}

	default File createFile(String path) {
		File file = new File(path);
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * 生成代码
	 * 
	 * @param tempName         模板名称
	 * @param bean             bean
	 * @param propertys        bean 的属性对象
	 * @param annotationAuthor 注释生成代码的人
	 * @return 代码
	 */
	default String createCode(String tempName, GenerateBean bean, List<GenerateProperty> propertys) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init(templateProperties());
		Template template = velocityEngine.getTemplate(tempName);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("bean", bean);
		velocityContext.put("propertyList", propertys);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		String code = stringWriter.toString();
		return code;
	}

	/**
	 * 设置获取模板是路径的配置
	 * 
	 * @return Properties
	 */
	default Properties templateProperties() {
		String fileDir = getClass().getResource("/vms/" + getTempType()).getPath();
		Properties properties = new Properties();
		properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, fileDir);
		return properties;
	}

	/**
	 * 生成 code 文件
	 * 
	 * @param file code 文件
	 * @param code code
	 */
	default void writeCodeToFile(File file, String code) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(code);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	Set<String> reverseTempNames(GenerateConfig config);

	void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName);

	void setCodePath(GenerateBean bean, GenerateConfig config, String tempName);

	String getTempType();
}
