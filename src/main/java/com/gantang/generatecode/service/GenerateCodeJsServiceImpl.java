package com.gantang.generatecode.service;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.gantang.generatecode.config.Config;
import com.gantang.generatecode.config.GenerateConfig;
import com.gantang.generatecode.model.GenerateBean;

/**
 * js 生成代码
 * 
 * @author jiangyp
 *
 */
public class GenerateCodeJsServiceImpl implements GenerateCodeService {

	@Override
	public Set<String> reverseTempNames(GenerateConfig config) {
		return config.getReverseJsTempName();
	}

	@Override
	public void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// gantang.
		StringBuilder beanPackage = new StringBuilder(config.getJsRootPackage() + ".");
		// mstdata.
		beanPackage.append(bean.getSchemaName().toLowerCase() + ".");
		// material.
		if (StringUtils.isNotEmpty(config.getAfterSchemaName())) {
			beanPackage.append(config.getAfterSchemaName() + ".");
		}
		// part.
		beanPackage.append(bean.getBeanName().toLowerCase() + ".");
		// Part
		beanPackage.append(bean.getBeanName());

		// gantang.mstdata.material.part.Part
		bean.setBeanPackagePrefix(beanPackage.toString());

		// Controller/Store/Mode/View
		beanPackage.append(tempName.substring(0, 1).toUpperCase() + tempName.substring(1));
		// gantang.mstdata.material.part.PartController
		bean.setBeanPackage(beanPackage.toString());
	}

	@Override
	public void setCodePath(GenerateBean bean, GenerateConfig config, String tempName) {
		String path = Config.generateCodePath() + getTempType() + "\\";
		String packagePath = bean.getBeanPackage().replace(config.getJsRootPackage() + ".", "");
		String fileName = bean.getBeanName() + tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
		packagePath = packagePath.replace(fileName, "");
		packagePath = packagePath.replace(".", "\\");
		bean.setCodePath(path + packagePath + "\\" + fileName + ".js");
	}

	@Override
	public String getTempType() {
		return "js";
	}

}
