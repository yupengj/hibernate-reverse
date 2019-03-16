package com.gantang.generatecode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbTypeUtil {

	private final Logger log = LoggerFactory.getLogger(DbTypeUtil.class);

	private static final String ORACLE = "Oracle";
	private static final String PG = "PostgreSQL";

	private static String DB_TYPE;

	public DbTypeUtil(String dbType) {
		if (dbType != null) {
			if (DB_TYPE == null) {
				// PostgreSQL JDBC Driver
				// Oracle JDBC Driver
				dbType = dbType.substring(0, dbType.indexOf("JDBC")).trim();
			}
			DB_TYPE = dbType;
			log.info("初始化当前连接数据库类型完成:" + DB_TYPE);
		}
	}

	public static boolean isPgSql() {
		return PG.equals(DB_TYPE);
	}

	public static boolean isOracle() {
		return ORACLE.equals(DB_TYPE);
	}

	@Override
	public String toString() {
		return "DbTypeUtil [DB_TYPE=" + DB_TYPE + "]";
	}

}
