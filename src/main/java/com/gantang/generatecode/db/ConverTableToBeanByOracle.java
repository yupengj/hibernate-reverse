package com.gantang.generatecode.db;

import com.gantang.generatecode.config.SelectDbConfig;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public class ConverTableToBeanByOracle implements ConverTableToBean {

	@Override
	public String getSql(SelectDbConfig selectDbConfig) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select m.owner as schemaName, m.table_name as tableName, m.column_name as columnName, m.data_type as columnType, d.comments, ");
		sql.append(" m.data_length as dataLength, m.data_precision as dataPrecision, m.data_scale as dataScale, m.nullable ");
		sql.append(" from all_tab_columns m  left join  all_col_comments d on (d.column_name = m.column_name and d.table_name = m.table_name) ");
		sql.append(" where 1=1 ");

		if (selectDbConfig.getSchema() != null && !selectDbConfig.getSchema().isEmpty()) {
			sql.append(buildSqlInWhere("m.owner", selectDbConfig.getSchema(), true));
		} else {
			sql.append(buildSqlInWhere("m.owner", selectDbConfig.getAllowSchema(), true));
		}
		sql.append(buildSqlInWhere("m.table_name", selectDbConfig.getTable(), true));
		sql.append(buildSqlInWhere("m.table_name", selectDbConfig.getIgnoreTable(), false));
		return sql.toString();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "schemaName", "tableName", "columnName", "columnType", "comments", "dataLength", "dataPrecision", "dataScale", "nullable" };
	}

	@Override
	public String convertByDbType(String key) {
		return key.toUpperCase();
	}
}
