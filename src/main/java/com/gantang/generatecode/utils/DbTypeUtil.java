package com.gantang.generatecode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbTypeUtil {

	private final Logger log = LoggerFactory.getLogger(DbTypeUtil.class);

	public static final String ORACLE = "Oracle";
	public static final String PG = "PostgreSQL";

	private static String CURRENT_DB_TYPE;

	public DbTypeUtil(String dbType) {
		if (dbType != null) {
			if (CURRENT_DB_TYPE == null) {
				// PostgreSQL JDBC Driver
				// Oracle JDBC Driver
				dbType = dbType.substring(0, dbType.indexOf("JDBC")).trim();
			}
			CURRENT_DB_TYPE = dbType;
			log.info("初始化当前连接数据库类型完成:" + CURRENT_DB_TYPE);
		}
	}

	public static String getCurrentDbType() {
		return CURRENT_DB_TYPE;
	}
}
