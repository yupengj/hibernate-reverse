package com.gantang.generatecode.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateConfig;
import com.gantang.generatecode.service.AbstractGenerateCodeService;

/**
 * 
 * @author jiangyp
 *
 */
@Component
public class GenerateCodeJavaServiceImpl extends AbstractGenerateCodeService {

	protected static final String TEMP_NAME_MODEL = "model";
	protected static final String TEMP_NAME_CONTROLLER = "controller";
	protected static final String PACKAGE_PREFIX = "com.gantang";

	@Override
	protected List<String> reverseTempNames(GenerateConfig config) {
		return config.getReverseJavaTempName();
	}

	@Override
	protected void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// mstdata
		String schemaName = bean.getSchemaName();
		// cust
		if (StringUtils.isNotEmpty(config.getBeforeSchemaName())) {
			schemaName = config.getBeforeSchemaName() + "." + schemaName;
		}
		// material
		if (StringUtils.isNotEmpty(config.getAfterSchemaName())) {
			schemaName = schemaName + "." + config.getAfterSchemaName();
		}
		// com.gantang.cust.mstdata
		String beanPackagePrefix = PACKAGE_PREFIX + "." + schemaName.toLowerCase();

		if (tempName.endsWith("Impl")) {
			tempName = tempName.substring(0, tempName.length() - 4) + ".impl";
		}
		if (TEMP_NAME_CONTROLLER.equals(tempName)) {
			tempName += "s";
		}
		// com.gantang.cust.mstdata.material.model
		String beanPackage = beanPackagePrefix + "." + tempName;
		bean.setBeanPackagePrefix(beanPackagePrefix);
		bean.setBeanPackage(beanPackage);
	}

	@Override
	protected String getFileName(String beanName, String tempName) {
		String fileSuffix = ".java";
		if (tempName.equals(TEMP_NAME_CONTROLLER)) {
			fileSuffix = ".groovy";
		}
		if (tempName.equals(TEMP_NAME_MODEL)) {
			tempName = "";
		} else {
			tempName = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
		}
		return beanName + tempName + fileSuffix;
	}

	@Override
	protected String getRootPath(String tempName) {
		return "../generatecode/java";
	}

	@Override
	protected String getTempType() {
		return "java";
	}

}
