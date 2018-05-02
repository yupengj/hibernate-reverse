package com.gantang.generatecode.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gantang.generatecode.GenerateCodeApplication;
import com.gantang.generatecode.model.GenerateBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GenerateCodeApplication.class)
public class GenerateCodeRepositoryTest {

	@Autowired
	GenerateCodeRepository generateCodeRepository;

	List<String> tableNames = new ArrayList<>();

	@Before
	public void before() {
		tableNames.add("BM_PART_ASSEMBLY");
	}

	@Test
	public void testSelectTableName() {
		List<Map<String, Object>> list = generateCodeRepository.selectTableName(null);
		list.stream().forEach(it -> {
			System.out.print(it.get("TABLE_NAME") + ", ");
		});
	}

	@Test
	public void testLoadBean() {
		List<GenerateBean> beans = generateCodeRepository.loadBean(tableNames);
		beans.forEach(System.out::println);
	}
}
