package com.gantang.generatecode.db;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.gantang.generatecode.config.SelectDbConfig;
import com.gantang.generatecode.model.GenerateBean;

public class ConverTableToBeanTest {

	@Test
	public void testGetSql() {
		String sql = ConverTableToBean.newInstance().getSql(SelectDbConfig.newInstance());
		assertNotNull(sql);
		assertNotEquals(sql, "");
	}

	@Test
	public void testLoadGenerateBean() {
		List<GenerateBean> list = ConverTableToBean.newInstance().loadGenerateBean(SelectDbConfig.newInstance());
		assertNotNull(list);
		assertTrue(list.size() != 0);
	}
}
