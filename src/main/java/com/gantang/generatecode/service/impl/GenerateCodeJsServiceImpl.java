package com.gantang.generatecode.service.impl;

import org.springframework.stereotype.Service;

import com.gantang.generatecode.dto.GenerateBean;
import com.gantang.generatecode.dto.GenerateConfig;
import com.gantang.generatecode.service.GenerateCodeService;

/**
 * js 生成代码
 * 
 * @author jiangyp
 *
 */
@Service("generateCodeJsService")
public class GenerateCodeJsServiceImpl implements GenerateCodeService {

	@Override
	public String[] reverseModel(GenerateConfig config) {
		return config.getJsModels();
	}

	@Override
	public void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// gantang.
		StringBuilder beanPackage = new StringBuilder(config.getJsRootPackage() + ".");
		// mstdata.
		beanPackage.append(bean.getSchemaName().toLowerCase() + ".");
		// material.
		if (config.getSuffixPackage() != null && config.getSuffixPackage().length() != 0) {
			beanPackage.append(config.getSuffixPackage() + ".");
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
		String path = config.getOutPath() + getTempType() + "\\";
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
