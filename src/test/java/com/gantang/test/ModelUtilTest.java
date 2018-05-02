package com.gantang.test;

import java.util.List;

import org.junit.Test;

import com.gantang.model.Bean;
import com.gantang.model.ModelUtil;

public class ModelUtilTest {

	ModelUtil model = new ModelUtil();

	@Test
	public void testLoadBean() {
		List<Bean> beans = model.loadBean();
		beans.stream().forEach(System.out::println);
	}

	@Test
	public void loadAnnotation() {
		System.out.println(model.loadAnnotation());
	}
}
