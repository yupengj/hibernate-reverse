package com.gantang.generatecode.db;

import com.gantang.generatecode.config.SelectDbConfig;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class ConverTableToBeanByPg implements ConverTableToBean {

	@Override
	public String getSql(SelectDbConfig selectDbConfig) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select n.nspname as schemaName, c.relname as tableName, a.attname as columnName, ");
		sql.append(" format_type(a.atttypid,a.atttypmod) as columnType, col_description ( a.attrelid, a.attnum ) as comments ");
		sql.append(" from pg_class as c,pg_attribute as a, pg_namespace as n ");
		sql.append("  where c.relnamespace = n.oid and c.oid = a.attrelid and a.attnum > 0 ");

		if (selectDbConfig.getSchema() != null && !selectDbConfig.getSchema().isEmpty()) {
			sql.append(buildSqlInWhere("n.nspname", selectDbConfig.getSchema(), true));
		} else {
			sql.append(buildSqlInWhere("n.nspname", selectDbConfig.getAllowSchema(), true));
		}
		sql.append(buildSqlInWhere("c.relname", selectDbConfig.getTable(), true));
		sql.append(buildSqlInWhere("c.relname", selectDbConfig.getIgnoreTable(), false));
		return sql.toString();
	}

	@Override
	public String convertByDbType(String key) {
		return key.toLowerCase();
	}

}
