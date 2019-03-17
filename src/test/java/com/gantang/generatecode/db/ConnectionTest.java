package com.gantang.generatecode.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.gantang.generatecode.utils.DbUtils;

public class ConnectionTest {

	@Test
	public void testConnection() throws SQLException {
		Connection conn = DbUtils.getConnection();
		assertNotNull(conn);
		DbUtils.closeController(conn);
	}
}
