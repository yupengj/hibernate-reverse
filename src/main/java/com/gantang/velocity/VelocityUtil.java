package com.gantang.velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.CodeGenerate;
import com.gantang.config.ConfigUtil;
import com.gantang.model.Annotation;
import com.gantang.model.Bean;
import com.gantang.model.Property;

public class VelocityUtil {
	static Logger log = LoggerFactory.getLogger(CodeGenerate.class);

	public void generateBean(List<String> tempNames, List<Bean> beans, Annotation annotation) throws Exception {
		for (Bean bean : beans) {
			for (String tempName : tempNames) {
				bean.setBeanUrl(javaPackage(bean.getSchemaName(), tempName));
				String path = javaFilePath(bean.getSchemaName(), tempName);
				File filePath = new File(path);
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				String fileName = path + javaFileName(bean.getBeanName(), tempName);
				File file = new File(fileName);
				FileWriter fw = new FileWriter(file);

				fw.write(createCode("java", tempName + ".vm", bean, bean.getProperties(), annotation));
				fw.flush();
				fw.close();
			}
		}
	}

	public String createCode(String tempType, String tempName, Bean bean, List<Property> propertys, Annotation annotation) throws Exception {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init(templateProperties(tempType));
		Template template = velocityEngine.getTemplate(tempName);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("bean", bean);
		velocityContext.put("annotation", annotation);
		velocityContext.put("propertys", propertys);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		String code = stringWriter.toString();
		return code;
	}

	public String javaFilePath(String schemaName, String tempName) {
		StringBuffer path = new StringBuffer(System.getProperty("user.dir") + "\\");
		path.append(ConfigUtil.getRootUrl() + "\\");
		path.append(javaPackage(schemaName, tempName).replace(".", "\\") + "\\");
		return path.toString();
	}

	public String javaPackage(String schemaName, String tempName) {
		if (tempName.endsWith("Impl")) {
			tempName = tempName.substring(0, tempName.length() - 4) + ".impl";
		}
		return ConfigUtil.getRootPackage() + "." + schemaName.toLowerCase() + "." + tempName;
	}

	public String javaFileName(String beanName, String tempName) {
		if (!tempName.equals("model")) {
			tempName = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
		} else {
			tempName = "";
		}
		return beanName + tempName + ".java";
	}

	public Properties templateProperties(String tempType) {
		String fileDir = VelocityUtil.class.getResource("/vms/" + tempType).getPath();
		Properties properties = new Properties();
		properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, fileDir);
		return properties;
	}
}
