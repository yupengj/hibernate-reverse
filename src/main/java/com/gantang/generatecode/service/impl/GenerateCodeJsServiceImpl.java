package com.gantang.generatecode.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateConfig;
import com.gantang.generatecode.service.AbstractGenerateCodeService;

/**
 * js 生成代码
 * 
 * @author jiangyp
 *
 */
@Component
public class GenerateCodeJsServiceImpl extends AbstractGenerateCodeService {

	@Override
	protected List<String> reverseTempNames(GenerateConfig config) {
		return config.getReverseJsTempName();
	}

	@Override
	protected void setBeanPackage(GenerateBean bean, GenerateConfig config, String tempName) {
		// mstdata
		String schemaName = bean.getSchemaName();
		// material
		if (StringUtils.isNotEmpty(config.getAfterSchemaName())) {
			schemaName = schemaName + "." + config.getAfterSchemaName();
		}
		// mstdata.material.part, 由于根据 beanPackage 生成文件路径，所以这里面没有加 gantang。
		String beanPackage = schemaName.toLowerCase() + "." + bean.getBeanName().toLowerCase();
		bean.setBeanPackage(beanPackage);
	}

	@Override
	protected String getFileName(String beanName, String tempName) {
		return beanName + tempName.substring(0, 1).toUpperCase() + tempName.substring(1) + ".js";
	}

	@Override
	protected String getRootPath(String tempName) {
		return "../generatecode/js";
	}

	@Override
	protected String getTempType() {
		return "js";
	}

}
