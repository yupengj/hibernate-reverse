package com.gantang.generatecode.controller;

import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gantang.generatecode.dto.GenerateBean;
import com.gantang.generatecode.dto.GenerateConfig;
import com.gantang.generatecode.service.GenerateCodeService;
import com.gantang.generatecode.service.MetadataService;

@Controller
public class IndexController {

	private final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	@Qualifier("generateCodeJavaService")
	GenerateCodeService generateCodeJavaService;
	@Autowired
	@Qualifier("generateCodeJsService")
	GenerateCodeService generateCodeJsService;
	@Autowired
	MetadataService metadataService;

	@RequestMapping("/")
	public String index(Model m) {
		return "index";
	}

	@RequestMapping(value = "/findAllTable", method = RequestMethod.POST)
	public String findAllTable(@RequestParam String tableName, Model m) {
		List<String> tables = metadataService.findAllTable(tableName);
		m.addAttribute("tables", tables);
		return "tableList::tableList";
	}

	@RequestMapping(value = "/generateCode", method = RequestMethod.POST)
	public String generateCode(@RequestBody GenerateConfig generateConfig) {
		log.info("生成代码配置信息: " + generateConfig.toString());
		List<GenerateBean> beans = metadataService.loadGenerateBean(generateConfig.getTableNames());
		log.info("初始化 Velocity 模板引擎");
		VelocityEngine velocityEngine = generateCodeJavaService.initVelocityEngine();
		log.info("开始生成 java 代码");
		generateCodeJavaService.generateCode(velocityEngine, beans, generateConfig);
		log.info("开始生成 js 代码");
		generateCodeJsService.generateCode(velocityEngine, beans, generateConfig);
		log.info("生成代码完成,代码路径: " + generateConfig.getOutPath());
		return "index";
	}
}
