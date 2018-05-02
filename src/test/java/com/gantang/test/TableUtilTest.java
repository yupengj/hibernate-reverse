package com.gantang.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.gantang.db.TableUtil;

public class TableUtilTest {

	@Test
	public void testSelectTable() {
		TableUtil tableUtil = new TableUtil();
		List<Object[]> tableNames = tableUtil.selectTableDesc();
		System.out.println(Arrays.toString(tableNames.toArray()));
	}
}
