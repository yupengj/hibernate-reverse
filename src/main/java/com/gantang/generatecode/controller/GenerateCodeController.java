package com.gantang.generatecode.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gantang.generatecode.SpringContextUtil;
import com.gantang.generatecode.model.GenerateConfig;
import com.gantang.generatecode.service.GenerateCodeService;

@Controller
public class GenerateCodeController {

	@RequestMapping("/")
	ModelAndView selectTables(ModelAndView mv) {
		mv.setViewName("index");
		mv.addObject("title", "欢迎使用自动生成代码!");
		return mv;
	}

	@RequestMapping("/generateCode")
	void generateCode(GenerateConfig config) {
		Map<String, GenerateCodeService> serviceMap = SpringContextUtil.getBeansOfType(GenerateCodeService.class);
		serviceMap.entrySet().stream().forEach(it -> it.getValue().generateCode(config));
	}

}
