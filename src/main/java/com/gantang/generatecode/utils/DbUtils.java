package com.gantang.generatecode.utils;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class DbUtils {

	private static String DRIVER_CLASS_NAME = null;
	private static final String PG = "org.postgresql.Driver";
	private static final String ORACLE = "oracle.jdbc.driver.OracleDriver";

	public static boolean isPgSql() {
		return PG.equals(DRIVER_CLASS_NAME);
	}

	public static boolean isOracle() {
		return ORACLE.equals(DRIVER_CLASS_NAME);
	}

	/**
	 * 初始化 数据库类型
	 */
	public static void initDbType(String driverClassName) {
		if (DRIVER_CLASS_NAME == null) {
			DRIVER_CLASS_NAME = driverClassName;
		}
	}
}
