package com.gantang.generatecode.config;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void testConfig() {
		System.out.println(Config.getValue("datasource.url"));
		System.out.println(Config.getValue("datasource.url"));
	}

	@Test
	public void testDataSourceConfig() {
		System.out.println(DataSourceConfig.newInstance());
	}

	@Test
	public void testSelectDbConfig() {
		System.out.println(SelectDbConfig.newInstance());
	}

	@Test
	public void testGenerateConfig() {
		System.out.println(GenerateConfig.newInstance());
	}
}
