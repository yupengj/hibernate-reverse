package com.gantang.generatecode.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gantang.generatecode.dao.MetadataDao;
import com.gantang.generatecode.dao.mapper.MetadataMapping;
import com.gantang.generatecode.dto.MetadataModel;
import com.gantang.generatecode.utils.DbUtils;
import com.zaxxer.hikari.HikariDataSource;

@Repository("metadataDao")
public class MetadataDaoImpl implements MetadataDao {

	private final Logger log = LoggerFactory.getLogger(MetadataDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void initDbType() {
		HikariDataSource dataSource = (HikariDataSource) jdbcTemplate.getDataSource();
		DbUtils.initDbType(dataSource.getDriverClassName());
		log.info("数据库连接 : url == " + dataSource.getJdbcUrl());
	}

	@Override
	public List<String> findAllTable(String tableName) {
		String sql = findAllTableSql(tableName);
		List<String> tables = jdbcTemplate.queryForList(sql, String.class);
		return tables;
	}

	private String findAllTableSql(String tableName) {
		if (DbUtils.isPgSql()) {
			return findAllTableSqlByPg(tableName);
		}
		if (DbUtils.isOracle()) {
			return findAllTableSqlByOracle(tableName);
		}
		return null;
	}

	private String findAllTableSqlByPg(String tableName) {
		StringBuffer sql = new StringBuffer("select tablename from pg_tables where 1=1 ");
		sql.append(buildSqlInWhere("schemaname", toLowerCase(allowSelectSchema()), true));
		sql.append(buildSqlInWhere("tablename", toLowerCase(ignoreTable()), false));
		if (tableName != null && tableName.length() != 0) {
			sql.append(" and tablename like '%" + tableName + "%'");
		}
		return sql.toString();
	}

	private String findAllTableSqlByOracle(String tableName) {
		String sql = "select TABLE_NAME FROM all_col_comments GROUP BY (TABLE_NAME,owner)"
				+ " HAVING owner in ('MSTDATA','CFGMGMT','BOMMGMT','CHGMGMT','COSTMGMT','CUST') and table_name <> 'schema_version' ";
		if (tableName != null && tableName.length() != 0) {
			sql += " and table_name like '%" + tableName.trim().toUpperCase() + "%'";
		}
		sql += " order by TABLE_NAME";
		return sql;
	}

	@Override
	public List<MetadataModel> findMetadataModel(String[] tables) {
		return jdbcTemplate.query(selectMetadataSql(tables), new MetadataMapping());
	}

	private String selectMetadataSql(String[] tables) {
		if (DbUtils.isPgSql()) {
			return selectMetadataSqlByPg(tables);
		}
		if (DbUtils.isOracle()) {
			return selectMetadataSqlByOracle(tables);
		}
		return null;
	}

	private String selectMetadataSqlByPg(String[] tables) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select n.nspname as schemaName, c.relname as tableName, a.attname as columnName, ");
		sql.append(" format_type(a.atttypid,a.atttypmod) as columnType, col_description ( a.attrelid, a.attnum ) as comments ");
		sql.append(" from pg_class as c,pg_attribute as a, pg_namespace as n ");
		sql.append("  where c.relnamespace = n.oid and c.oid = a.attrelid and a.attnum > 0 ");
		sql.append(buildSqlInWhere("n.nspname", toLowerCase(allowSelectSchema()), true));
		sql.append(buildSqlInWhere("c.relname", toLowerCase(ignoreTable()), false));

		if (tables != null && tables.length != 0) {
			sql.append(buildSqlInWhere("c.relname", tables, true));
		}

		return sql.toString();
	}

	private String selectMetadataSqlByOracle(String[] tables) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select m.owner as schemaName, m.table_name as tableName, m.column_name as columnName, m.data_type as columnType, d.comments, ");
		sql.append(" m.data_length as dataLength, m.data_precision as dataPrecision, m.data_scale as dataScale, m.nullable ");
		sql.append(" from all_tab_columns m  left join  all_col_comments d on (d.column_name = m.column_name and d.table_name = m.table_name) ");
		sql.append(" where 1=1 ");

		sql.append(buildSqlInWhere("m.owner", allowSelectSchema(), true));
		sql.append(buildSqlInWhere("m.table_name", ignoreTable(), false));

		if (tables != null && tables.length != 0) {
			sql.append(buildSqlInWhere("m.table_name", tables, true));
		}

		return sql.toString();
	}

	private String[] allowSelectSchema() {
		return new String[] { "MSTDATA", "CFGMGMT", "CHGMGMT", "BOMMGMT", "COSTMGMT", "COSTMGMT", "CUST", "INTEGRATION" };
	}

	private String[] toLowerCase(String[] data) {
		return Stream.of(data).map(String::toLowerCase).toArray(String[]::new);
	}

	private String[] ignoreTable() {
		return new String[] { "SCHEMA_VERSION" };
	}

	/**
	 * 向 sql 后增加 in 查询条件
	 * 
	 * @param columnName 列名
	 * @param params     条件值
	 * @param isIn       true 是 in ,false 为 not in
	 * @return where
	 */
	private String buildSqlInWhere(String columnName, String[] params, boolean isIn) {
		if (params == null || params.length == 0) {
			return "";
		}
		StringBuffer hql = new StringBuffer(" and " + columnName);
		if (isIn) {
			hql.append(" in ( ");
		} else {
			hql.append(" not in ( ");
		}
		hql.append(Stream.of(params).map(it -> "'" + it + "'").collect(Collectors.joining(",")));
		hql.append(" )");
		return hql.toString();
	};
}
