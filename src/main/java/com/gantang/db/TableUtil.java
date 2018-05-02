package com.gantang.db;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;

import com.gantang.config.ConfigUtil;

public class TableUtil {

	@SuppressWarnings("unchecked")
	public List<Object[]> selectTableDesc() {
		Session session = DBUtil.getSession();
		List<Object[]> tableDescs = null;
		try {
			tableDescs = session.createSQLQuery(getTableDescSql()).list();
		} finally {
			DBUtil.colseSession(session);
		}
		return tableDescs;
	}

	protected String getTableDescSql() {
		List<String> schemaNames = ConfigUtil.getSchemaName();
		List<String> tableNames = ConfigUtil.getTableName();
		if (schemaNames.isEmpty() && tableNames.isEmpty()) {
			throw new RuntimeException("配置文件中属性 reverse_schema_name 和 reverse_table_name 不能同时为空");
		}

		StringBuffer hql = new StringBuffer(
				"select owner,table_name,column_name,data_type,data_length,data_precision,data_scale,nullable from all_tab_columns");
		hql.append(" where 1=1");
		if (!schemaNames.isEmpty()) {
			hql.append(" and owner in ( ");
			hql.append(schemaNames.stream().map(it -> "'" + it + "'").collect(Collectors.joining(",")));
			hql.append(" )");
		}

		if (!tableNames.isEmpty()) {
			hql.append(" and table_name in ( ");
			hql.append(tableNames.stream().map(it -> "'" + it + "'").collect(Collectors.joining(",")));
			hql.append(" )");
		}

		List<String> notTableNames = ConfigUtil.getNotTableName();
		if (!notTableNames.isEmpty()) {
			hql.append(" and table_name not in ( ");
			hql.append(notTableNames.stream().map(it -> "'" + it + "'").collect(Collectors.joining(",")));
			hql.append(" )");
		}
		return hql.toString();
	}
}
