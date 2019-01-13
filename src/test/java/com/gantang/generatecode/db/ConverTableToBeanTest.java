package com.gantang.generatecode.db;

import org.junit.Before;
import org.junit.Test;

import com.gantang.generatecode.config.SelectDbConfig;

public class ConverTableToBeanTest {

	ConverTableToBean cttb = null;

	@Before
	public void beford() {
		cttb = new ConverTableToBeanByOracle();
	}

	@Test
	public void testSelectTable() {
		cttb.loadGenerateBean(SelectDbConfig.newInstance());
	}
}
