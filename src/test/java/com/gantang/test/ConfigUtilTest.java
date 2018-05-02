package com.gantang.test;

import java.util.Arrays;

import org.junit.Test;

import com.gantang.config.ConfigUtil;

public class ConfigUtilTest {

	@Test
	public void testRootUrl() {
		System.out.println("--testRootUrl--");
		System.out.println(ConfigUtil.getRootUrl());
		System.out.println();
	}

	@Test
	public void testSchemaName() {
		System.out.println("--testSchemaName--");
		System.out.println(Arrays.toString(ConfigUtil.getSchemaName().toArray()));
		System.out.println();
	}

	@Test
	public void testTableName() {
		System.out.println("--testTableName--");
		System.out.println(Arrays.toString(ConfigUtil.getTableName().toArray()));
		System.out.println();
	}

	@Test
	public void testTempName() {
		System.out.println("--testTempName--");
		System.out.println(Arrays.toString(ConfigUtil.getJavaTempName().toArray()));
		System.out.println();
	}

	@Test
	public void testNotTableName() {
		System.out.println("--testNotTableName--");
		System.out.println(Arrays.toString(ConfigUtil.getNotTableName().toArray()));
		System.out.println();
	}

}
