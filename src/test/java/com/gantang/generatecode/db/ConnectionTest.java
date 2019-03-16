package com.gantang.generatecode.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.gantang.generatecode.utils.DbTypeUtil;
import com.gantang.generatecode.utils.DbUtils;

public class ConnectionTest {

	@Test
	public void testOraConnection() throws SQLException {

		Connection conn = DbUtils.getConnection();
		System.out.println(conn);
		System.out.println(conn.getMetaData().getDriverName());


		DbUtils.closeController(conn);
	}
}
