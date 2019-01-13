package com.gantang.generatecode.service;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.gantang.generatecode.config.Config;
import com.gantang.generatecode.config.GenerateConfig;
import com.gantang.generatecode.model.GenerateBean;

/**
 * 
 * @author jiangyp
 *
 */
public class GenerateCodeJavaServiceImpl implements GenerateCodeService {

	protected static final String TEMP_NAME_MODEL = "model";
	protected static final String TEMP_NAME_CONTROLLER = "controller";

	@Override
	public Set<String> reverseTempNames(GenerateConfig config) {
		return config.getReverseJavaTempName();
	}

	@Override
	public void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// com.gantang.
		StringBuilder beanPackage = new StringBuilder(config.getRootPackage() + ".");
		// com.gantang.cust.
		if (StringUtils.isNotEmpty(config.getBeforeSchemaName())) {
			beanPackage.append(config.getBeforeSchemaName() + ".");
		}
		// com.gantang.cust.mstdata.
		beanPackage.append(bean.getSchemaName().toLowerCase() + ".");
		// com.gantang.cust.mstdata.material.
		if (StringUtils.isNotEmpty(config.getAfterSchemaName())) {
			beanPackage.append(config.getAfterSchemaName() + ".");
		}

		String beanPackagePrefix = beanPackage.toString();
		// com.gantang.cust.mstdata.material
		bean.setBeanPackagePrefix(beanPackagePrefix.substring(0, beanPackagePrefix.length() - 1));

		if (tempName.endsWith("Impl")) {
			tempName = tempName.substring(0, tempName.length() - 4) + ".impl";
		}
		if (TEMP_NAME_CONTROLLER.equals(tempName)) {
			tempName += "s";
		}
		beanPackage.append(tempName);
		// com.gantang.cust.mstdata.material.model
		bean.setBeanPackage(beanPackage.toString());
	}

	@Override
	public void setCodePath(GenerateBean bean, GenerateConfig config, String tempName) {
		String path = Config.codeRootPath() + getTempType() + "\\";
		path += bean.getBeanPackage().replace(".", "\\");

		String fileSuffix = ".java";
		if (tempName.equals(TEMP_NAME_CONTROLLER)) {
			fileSuffix = ".groovy";
		}
		if (tempName.equals(TEMP_NAME_MODEL)) {
			tempName = "";
		} else {
			tempName = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
		}
		String fileName = bean.getBeanName() + tempName + fileSuffix;

		bean.setCodePath(path + "\\" + fileName);
	}

	@Override
	public String getTempType() {
		return "java";
	}
}
