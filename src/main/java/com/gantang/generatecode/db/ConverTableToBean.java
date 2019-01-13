package com.gantang.generatecode.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gantang.generatecode.GenerateCode;
import com.gantang.generatecode.config.SelectDbConfig;
import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateProperty;
import com.gantang.generatecode.utils.DbTypeUtil;
import com.gantang.generatecode.utils.DbUtils;

public interface ConverTableToBean {

	final Logger log = LoggerFactory.getLogger(GenerateCode.class);

	/**
	 * 加载一个表，转换成一个java对象
	 * 
	 * @param tableNames 表名称
	 * @return list Bean
	 */
	public default List<GenerateBean> loadGenerateBean(SelectDbConfig selectDbConfig) {
		List<GenerateBean> beans = new ArrayList<>();

		List<Map<String, Object>> list = DbUtils.queryForList(selectTableColumnSql(selectDbConfig));

		Map<String, List<Map<String, Object>>> bean2Propertys = list.stream()
				.collect(Collectors.groupingBy(it -> it.get("owner") + "@" + it.get("table_name")));

		for (Entry<String, List<Map<String, Object>>> entry : bean2Propertys.entrySet()) {
			String tableName = entry.getKey().split("@")[1];
			String schemaName = entry.getKey().split("@")[0];
			GenerateBean bean = new GenerateBean(handleBeanName(tableName), tableName, schemaName, loadProperty(entry.getValue(), tableName));
			beans.add(bean);
		}
		return beans;
	}

	/**
	 * 把表名转成类名：BM_PART_ASSEMBLY 转成 PartAssembly
	 * 
	 * @param tableName tableName
	 * @return className
	 */
	default String handleBeanName(String tableName) {
		if (tableName.contains("_")) {
			String[] array = tableName.split("_");
			String beanName = "";
			for (int i = 1; i < array.length; i++) {
				// 第一个元素去掉
				String str = array[i];
				beanName = beanName + str.substring(0, 1) + str.substring(1).toLowerCase();
			}
			return beanName;
		} else {
			return tableName.substring(0, 1) + tableName.substring(1).toLowerCase();
		}
	}

	/**
	 * 不生成属性的字段
	 * 
	 * @return list
	 */
	default List<String> filterPropertyName() {
		String[] filterNames = { "id", "createdBy", "createDate", "updatedBy", "updateDate", "isDeleted", "deleteDate", "deletedBy", "optCounter" };
		return Arrays.asList(filterNames);
	}

	/**
	 * 把数据库中的列明转成类中的属性名 LINE_NUM 转成 lineNum。如果“列名加_ID” 等于表名直接返回“id”
	 * 
	 * @param cloumnName 列名
	 * @param tableName  表名
	 * @return propertyName
	 */
	default String handlePropertyName(String cloumnName, String tableName) {
		if (cloumnName.toUpperCase().equals((tableName + "_ID").toUpperCase())) {
			return "id";
		}
		if (cloumnName.contains("_")) {
			String[] array = cloumnName.split("_");
			String name = array[0].toLowerCase();
			for (int i = 1; i < array.length; i++) {
				// 第一个元素去掉,因为第一个是 MD_ 或其他
				String str = array[i];
				name = name + str.substring(0, 1) + str.substring(1).toLowerCase();
			}
			return name;
		} else {
			return cloumnName.toLowerCase();
		}
	}

	default String buildSqlInWhere(String columnName, Set<String> params, boolean isIn) {
		if (params == null || params.isEmpty()) {
			return "";
		}
		StringBuffer hql = new StringBuffer(" and " + columnName);
		if (isIn) {
			hql.append(" in ( ");
		} else {
			hql.append(" not in ( ");
		}
		hql.append(params.stream().map(it -> "'" + convertByDbType(it) + "'").collect(Collectors.joining(",")));
		hql.append(" )");
		return hql.toString();
	};

	static ConverTableToBean newInstance() {
		if (DbTypeUtil.ORACLE.equals(DbTypeUtil.getCurrentDbType())) {
			return new ConverTableToBeanByOracle();
		}
		if (DbTypeUtil.PG.equals(DbTypeUtil.getCurrentDbType())) {
			return new ConverTableToBeanByOracle();
		}
		return null;
	}

	default String convertByDbType(String key) {
		return key;
	};

	String selectTableColumnSql(SelectDbConfig selectDbConfig);

	List<GenerateProperty> loadProperty(List<Map<String, Object>> objects, String tableName);
}
