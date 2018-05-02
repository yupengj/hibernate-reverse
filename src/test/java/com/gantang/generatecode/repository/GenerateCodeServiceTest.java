package com.gantang.generatecode.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gantang.generatecode.GenerateCodeApplication;
import com.gantang.generatecode.SpringContextUtil;
import com.gantang.generatecode.model.GenerateConfig;
import com.gantang.generatecode.service.GenerateCodeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GenerateCodeApplication.class)
public class GenerateCodeServiceTest {

	GenerateConfig config = new GenerateConfig();
	List<String> tables = new ArrayList<>();
	List<String> javaTempName = new ArrayList<>();
	List<String> jsTempName = new ArrayList<>();

	@Before
	public void before() {
		setTables();
		setJavaTempName();
		setJsTempName();

		config.setAnnotationAuthorName("jiangyp");
		config.setBeforeSchemaName("prd");
		config.setReverseTableName(tables);
		config.setReverseJavaTempName(javaTempName);
		config.setReverseJsTempName(jsTempName);
	}

	public void setTables() {
		tables.add("BM_PART_ASSEMBLY");
	}

	public void setJavaTempName() {
		javaTempName.add("model");
		javaTempName.add("dao");
		javaTempName.add("daoImpl");
		javaTempName.add("service");
		javaTempName.add("serviceImpl");
		javaTempName.add("controller");
	}

	public void setJsTempName() {
		jsTempName.add("model");
		jsTempName.add("store");
		jsTempName.add("view");
		jsTempName.add("controller");
	}

	@Test
	public void testGenerateCode() {
		Map<String, GenerateCodeService> serviceMap = SpringContextUtil.getBeansOfType(GenerateCodeService.class);
		serviceMap.entrySet().stream().forEach(it -> it.getValue().generateCode(config));
	}

}
