package com.gantang.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gantang.config.ConfigUtil;
import com.gantang.model.Annotation;
import com.gantang.model.Bean;
import com.gantang.model.ModelUtil;
import com.gantang.velocity.VelocityUtil;

public class VelocityTest {
	VelocityUtil velocityUtil = new VelocityUtil();
	ModelUtil modelUtil = new ModelUtil();
	List<Bean> beans = null;

	@Before
	public void setBeans() {
		beans = modelUtil.loadBean();
	}

	@Test
	public void testJavaFilePath() {
		List<String> tempNames = ConfigUtil.getJavaTempName();
		for (Bean bean : beans) {
			for (String tempName : tempNames) {
				String javaFilePath = velocityUtil.javaFilePath(bean.getSchemaName(), tempName);
				System.out.println("javaFilePath: " + javaFilePath);

				String javaPackage = velocityUtil.javaPackage(bean.getSchemaName(), tempName);
				System.out.println("javaPackage: " + javaPackage);

				String javaFileName = velocityUtil.javaFileName(bean.getBeanName(), tempName);
				System.out.println("javaFileName: " + javaFileName);
			}
		}
	}

	@Test
	public void testCreateCode() {
		List<String> tempNames = ConfigUtil.getJavaTempName();
		VelocityUtil velocityUtil = new VelocityUtil();
		ModelUtil modelUtil = new ModelUtil();
		Annotation annotation = modelUtil.loadAnnotation();
		List<Bean> beans = new ArrayList<>();
		Bean bean = new Bean("PartAssembly", "BM_PART_ASSEMBLY", "BOMMGMT", new ArrayList<>());
		beans.add(bean);
		try {
			velocityUtil.generateBean(tempNames, beans, annotation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
