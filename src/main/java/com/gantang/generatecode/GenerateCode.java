package com.gantang.generatecode;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.generatecode.config.Config;
import com.gantang.generatecode.config.GenerateConfig;
import com.gantang.generatecode.config.SelectDbConfig;
import com.gantang.generatecode.db.ConverTableToBean;
import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.service.GenerateCodeJavaServiceImpl;
import com.gantang.generatecode.service.GenerateCodeJsServiceImpl;
import com.gantang.generatecode.service.GenerateCodeService;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class GenerateCode {

	/**
	 * 主方法
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {

		final Logger log = LoggerFactory.getLogger(GenerateCode.class);

		List<GenerateBean> beans = ConverTableToBean.newInstance().loadGenerateBean(SelectDbConfig.newInstance());
		log.info("查询要生成代码的表完成, 共生成 :" + beans.size() + " 个表");

		GenerateConfig generateConfig = GenerateConfig.newInstance();

		GenerateCodeService generateCodeService = new GenerateCodeJavaServiceImpl();
		generateCodeService.generateCode(beans, generateConfig);

		generateCodeService = new GenerateCodeJsServiceImpl();
		generateCodeService.generateCode(beans, generateConfig);

		log.info("生成代码成功,代码路径:" + Config.generateCodePath());
	}
}
