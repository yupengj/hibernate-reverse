package com.gantang.generatecode.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryUtils {

	private static final Logger LOG = LoggerFactory.getLogger(QueryUtils.class);

	public static List<Map<String, Object>> queryForList(String sql, String[] columns) {
		LOG.info("sql :" + sql);
		LOG.info("查询的列:" + Arrays.toString(columns));
		Connection conn = DbUtils.getConnection();
		List<Map<String, Object>> result = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				for (String column : columns) {
					map.put(column, rs.getObject(column));
				}
				result.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbUtils.closeController(conn);
		}
		return result;
	}
}
