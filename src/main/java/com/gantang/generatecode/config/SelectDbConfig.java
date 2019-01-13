package com.gantang.generatecode.config;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectDbConfig {

	private final Logger log = LoggerFactory.getLogger(SelectDbConfig.class);

	private static final String ALLOW_SCHEMA_KEY = "allowSchema";
	private static final String SCHEMA_KEY = "schema";
	private static final String TABLE_KEY = "table";
	private static final String IGNORE_TABLE = "ignoreTable";

	private static SelectDbConfig selectDbConfig = new SelectDbConfig();

	private Set<String> allowSchema;
	private Set<String> schema;
	private Set<String> table;
	private Set<String> ignoreTable;

	private SelectDbConfig() {
		initSelectDbConfig();
		log.info("初始化数据库连接参数完成");
	}

	public static SelectDbConfig newInstance() {
		return selectDbConfig;
	}

	private void initSelectDbConfig() {
		this.allowSchema = Config.getSetValue(ALLOW_SCHEMA_KEY);
		if (this.allowSchema == null || allowSchema.isEmpty()) {
			throw new RuntimeException(ALLOW_SCHEMA_KEY + "配置不能为空");
		}
		this.schema = Config.getSetValue(SCHEMA_KEY);
		if (this.schema != null && !this.schema.isEmpty()) {
			this.schema.removeIf(it -> !allowSchema.contains(it));
		}
		this.table = Config.getSetValue(TABLE_KEY);
		this.ignoreTable = Config.getSetValue(IGNORE_TABLE);
		if (this.table != null && this.ignoreTable != null) {
			this.table.removeIf(it -> ignoreTable.contains(it));
		}
	}

	public Set<String> getAllowSchema() {
		return allowSchema;
	}

	public void setAllowSchema(Set<String> allowSchema) {
		this.allowSchema = allowSchema;
	}

	public Set<String> getSchema() {
		return schema;
	}

	public void setSchema(Set<String> schema) {
		this.schema = schema;
	}

	public Set<String> getTable() {
		return table;
	}

	public void setTable(Set<String> table) {
		this.table = table;
	}

	public Set<String> getIgnoreTable() {
		return ignoreTable;
	}

	public void setIgnoreTable(Set<String> ignoreTable) {
		this.ignoreTable = ignoreTable;
	}

	@Override
	public String toString() {
		return "SelectDbConfig [allowSchema=" + allowSchema + ", schema=" + schema + ", table=" + table + ", ignoreTable=" + ignoreTable + "]";
	}

}
