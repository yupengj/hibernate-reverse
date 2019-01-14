package com.gantang.generatecode.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.generatecode.config.DataSourceConfig;

public class DbUtils {

	private static final Logger log = LoggerFactory.getLogger(DbUtils.class);

	private static DataSourceConfig dsConfig = DataSourceConfig.newInstance();

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(dsConfig.getDriver());
			conn = DriverManager.getConnection(dsConfig.getUrl(), dsConfig.getUserName(), dsConfig.getPassword());

			log.info("连接数据库成功:" + dsConfig);
		} catch (Exception e) {
			throw new RuntimeException("获取数据库连接失败 " + e.getMessage());
		}
		return conn;
	}

	public static void closeController(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void initDbType() {
		Connection conn = getConnection();
		try {
			new DbTypeUtil(conn.getMetaData().getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeController(conn);
		}
	}

	public static <T> List<Map<String, Object>> queryForList(String hql) {
		Connection conn = getConnection();
		List<Map<String, Object>> result = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(hql);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				for (String column : resultColumns(hql)) {
					map.put(column, rs.getObject(column));
				}
				result.add(map);
			}
			log.info(hql);
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
			closeController(conn);
		}
		return result;
	}

	private static List<String> resultColumns(String hql) {
		String columns = hql.substring(hql.indexOf("select") + "select".length(), hql.indexOf("from")).trim();
		String[] columnsArr = columns.split(",");
		return Stream.of(columnsArr).filter(it -> it != null && it.length() != 0).map(it -> it.substring(it.indexOf(".") + 1)).collect(Collectors.toList());
	}
}
