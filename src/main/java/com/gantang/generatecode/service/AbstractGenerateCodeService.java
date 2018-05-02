package com.gantang.generatecode.service;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateConfig;
import com.gantang.generatecode.model.GenerateProperty;
import com.gantang.generatecode.repository.GenerateCodeRepository;

public abstract class AbstractGenerateCodeService implements GenerateCodeService {

	@Autowired
	protected GenerateCodeRepository generateCodeRepository;

	@Override
	public void generateCode(GenerateConfig config) {
		List<GenerateBean> beans = generateCodeRepository.loadBean(config.getReverseTableName());
		for (GenerateBean bean : beans) {
			generateCode(config, bean, config.getAnnotationAuthorName());
		}
	}

	/**
	 * 生成代码
	 * 
	 * @param bean
	 *            bean
	 * @param annotationAuthor
	 *            annotationAuthor
	 * @param config
	 *            配置信息
	 */
	public void generateCode(GenerateConfig config, GenerateBean bean, String annotationAuthor) {
		for (String tempName : reverseTempNames(config)) {
			setBeanPackage(bean, config, tempName);
			File file = createCodeFile(bean, tempName);
			if (file != null) {
				String code = createCode(tempName + ".vm", bean, bean.getProperties(), annotationAuthor);
				writeCodeToFile(file, code);
			}
		}
	}

	/**
	 * 创建生成代码的文件，如果文件存在返回null
	 * 
	 * @param bean
	 *            bean
	 * @param tempName
	 *            模板名称
	 * @return File
	 */
	protected File createCodeFile(GenerateBean bean, String tempName) {
		// 创建文件件
		String path = createFolder(getRootPath(tempName), bean.getBeanPackage());
		// 得到代码文件路径
		String filePath = path + getFileName(bean.getBeanName(), tempName);
		// 创建文件，如果文件已存在则不处理，防止把已有的代码覆盖
		File file = new File(filePath);
		if (file.exists()) {
			return null;
		}
		return file;
	}

	/**
	 * 根据跟目录和Package 创建文件件
	 * 
	 * @param rootPath
	 *            跟路径
	 * @param beanPackage
	 *            beanPackage
	 * @return 文件路径
	 */
	protected String createFolder(String rootPath, String beanPackage) {
		StringBuffer path = new StringBuffer(System.getProperty("user.dir") + "/");
		path.append(rootPath + "/" + beanPackage.replace(".", "/") + "/");
		File filePath = new File(path.toString());
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		return path.toString();
	}

	/**
	 * 生成代码
	 * 
	 * @param tempName
	 *            模板名称
	 * @param bean
	 *            bean
	 * @param propertys
	 *            bean 的属性对象
	 * @param annotationAuthor
	 *            注释生成代码的人
	 * @return 代码
	 */
	protected String createCode(String tempName, GenerateBean bean, List<GenerateProperty> propertys, String annotationAuthor) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty("input.encoding", "UTF-8");
		velocityEngine.setProperty("output.encoding", "UTF-8");
		velocityEngine.init(templateProperties());
		Template template = velocityEngine.getTemplate(tempName);
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("bean", bean);
		velocityContext.put("annotationAuthor", annotationAuthor);
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
	protected Properties templateProperties() {
		String fileDir = getClass().getResource("/vms/" + getTempType()).getPath();
		Properties properties = new Properties();
		properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, fileDir);
		return properties;
	}

	/**
	 * 生成 code 文件
	 * 
	 * @param file
	 *            code 文件
	 * @param code
	 *            code
	 */
	protected void writeCodeToFile(File file, String code) {
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

	protected abstract List<String> reverseTempNames(GenerateConfig config);

	protected abstract void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName);

	protected abstract String getFileName(String beanName, String tempName);

	protected abstract String getRootPath(String tempName);

	protected abstract String getTempType();

}
