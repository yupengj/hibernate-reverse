package com.gantang;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.config.ConfigUtil;
import com.gantang.model.Annotation;
import com.gantang.model.Bean;
import com.gantang.model.ModelUtil;
import com.gantang.velocity.VelocityUtil;

public class CodeGenerate {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		List<String> tempNames = ConfigUtil.getJavaTempName();
		VelocityUtil velocityUtil = new VelocityUtil();
		ModelUtil modelUtil = new ModelUtil();
		List<Bean> beans = modelUtil.loadBean();
		Annotation annotation = modelUtil.loadAnnotation();

		List<Bean> beans2 = new ArrayList<>();
		beans2.add(beans.get(0));
		try {
			velocityUtil.generateBean(tempNames, beans2, annotation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
