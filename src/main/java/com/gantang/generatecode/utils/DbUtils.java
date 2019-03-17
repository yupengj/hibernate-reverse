package com.gantang.generatecode.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.generatecode.config.DataSourceConfig;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class DbUtils {

	private static final Logger LOG = LoggerFactory.getLogger(DbUtils.class);

	private static final String ORACLE = "Oracle";
	private static final String PG = "PostgreSQL";
	private static String DB_TYPE;

	private static final DataSourceConfig DS_CONFIG = DataSourceConfig.newInstance();

	/**
	 * 获得连接
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DS_CONFIG.getDriver());
			conn = DriverManager.getConnection(DS_CONFIG.getUrl(), DS_CONFIG.getUserName(), DS_CONFIG.getPassword());

			LOG.info("连接数据库成功:" + DS_CONFIG);
		} catch (Exception e) {
			throw new RuntimeException("获取数据库连接失败 " + e.getMessage());
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn Connection
	 */
	public static void closeController(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isPgSql() {
		return PG.equals(DB_TYPE);
	}

	public static boolean isOracle() {
		return ORACLE.equals(DB_TYPE);
	}

	/**
	 * 初始化 数据库类型
	 */
	public static void initDbType() {
		if (DB_TYPE == null) {
			Connection conn = getConnection();
			try {
				String type = conn.getMetaData().getDriverName();
				DB_TYPE = type.substring(0, type.indexOf("JDBC")).trim();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeController(conn);
			}
		}
	}
}
