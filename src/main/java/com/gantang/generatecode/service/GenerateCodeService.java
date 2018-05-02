package com.gantang.generatecode.service;

import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateConfig;

public interface GenerateCodeService {

	void generateCode(GenerateConfig config);

	void generateCode(GenerateConfig config, GenerateBean bean, String authorName);

}
