package com.gantang.generatecode.service.impl;

import org.springframework.stereotype.Service;

import com.gantang.generatecode.dto.GenerateBean;
import com.gantang.generatecode.dto.GenerateConfig;
import com.gantang.generatecode.service.GenerateCodeService;

/**
 * 
 * @author jiangyp
 *
 */
@Service("generateCodeJavaService")
public class GenerateCodeJavaServiceImpl implements GenerateCodeService {

	protected static final String TEMP_NAME_MODEL = "model";
	protected static final String TEMP_NAME_CONTROLLER = "controller";

	@Override
	public String[] reverseModel(GenerateConfig config) {
		return config.getJavaModels();
	}

	@Override
	public void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// com.gantang.
		StringBuilder beanPackage = new StringBuilder(config.getJavaRootPackage() + ".");
		// com.gantang.cust.
		if (config.getPrefixPackage() != null && config.getPrefixPackage().length() != 0) {
			beanPackage.append(config.getPrefixPackage() + ".");
		}
		// com.gantang.cust.mstdata.
		beanPackage.append(bean.getSchemaName().toLowerCase() + ".");
		// com.gantang.cust.mstdata.material.
		if (config.getSuffixPackage() != null && config.getSuffixPackage().length() != 0) {
			beanPackage.append(config.getSuffixPackage() + ".");
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
		String path = config.getOutPath() + getTempType() + "\\";
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
