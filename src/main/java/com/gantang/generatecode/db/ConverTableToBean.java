package com.gantang.generatecode.db;

import java.math.BigDecimal;
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
import com.gantang.generatecode.utils.DbUtils;
import com.gantang.generatecode.utils.QueryUtils;

/**
 * 
 * @author jyp10@foxmail.com
 *
 */
public interface ConverTableToBean {

	Logger LOG = LoggerFactory.getLogger(GenerateCode.class);

	/**
	 * 加载一个表结构，转换成一个java对象
	 * 
	 * @param selectDbConfig 查询配置
	 * @return list Bean
	 */
	default List<GenerateBean> loadGenerateBean(SelectDbConfig selectDbConfig) {
		List<GenerateBean> beans = new ArrayList<>();

		List<Map<String, Object>> list = QueryUtils.queryForList(getSql(selectDbConfig), getColumnNames());

		Map<String, List<Map<String, Object>>> bean2Propertys = list.stream()
				.collect(Collectors.groupingBy(it -> it.get("schemaName") + "@" + it.get("tableName")));

		for (Entry<String, List<Map<String, Object>>> entry : bean2Propertys.entrySet()) {
			String schemaName = entry.getKey().split("@")[0];
			String tableName = entry.getKey().split("@")[1];
			GenerateBean bean = new GenerateBean(tableName, schemaName, loadProperty(entry.getValue(), tableName));
			beans.add(bean);
		}
		return beans;
	}

	/**
	 * 得到 sql
	 * 
	 * @param selectDbConfig 查询配置信息
	 * @return sql
	 */
	String getSql(SelectDbConfig selectDbConfig);

	/**
	 * 这些属性必须有
	 * 
	 * @return 查询属性
	 */
	default String[] getColumnNames() {
		return new String[] { "schemaName", "tableName", "columnName", "columnType", "comments" };
	}

	/**
	 * 把表结构转成对象集合
	 * 
	 * @param objects   表结构数据
	 * @param tableName 表名
	 * @return 表属性对象
	 */
	default List<GenerateProperty> loadProperty(List<Map<String, Object>> objects, String tableName) {
		List<GenerateProperty> propertys = new ArrayList<>();
		List<String> filterNames = filterPropertyName();
		for (Map<String, Object> obj : objects) {
			String cloumnName = (String) obj.get("columnName");
			String name = handlePropertyName(cloumnName, tableName);
			if (filterNames.contains(name)) {
				continue;
			}
			Integer length = obj.get("dataLength") == null ? null : ((BigDecimal) obj.get("dataLength")).intValue();
			Integer precision = obj.get("dataPrecision") == null ? null : ((BigDecimal) obj.get("dataPrecision")).intValue();
			Integer scale = obj.get("dataScale") == null ? null : ((BigDecimal) obj.get("dataScale")).intValue();
			String comments = obj.get("comments") == null ? null : obj.get("comments").toString();
			GenerateProperty property = new GenerateProperty(name, cloumnName, comments, (String) obj.get("columnType"), length, precision, scale,
					(String) obj.get("number"));
			propertys.add(property);
		}
		return propertys;
	}

	/**
	 * 把表名转成类名：BM_PART_ASSEMBLY 转成 PartAssembly
	 * 
	 * @param tableName tableName
	 * @return className
	 */

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
			cloumnName = cloumnName.toUpperCase();
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

	/**
	 * 向 sql 后增加 in 查询条件
	 * 
	 * @param columnName 列名
	 * @param params     条件值
	 * @param isIn       true 是 in ,false 为 not in
	 * @return where
	 */
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

	/**
	 * 根据数据库的连接创建不同的实例
	 * 
	 * @return ConverTableToBean
	 */
	static ConverTableToBean newInstance() {
		DbUtils.initDbType();
		if (DbUtils.isOracle()) {
			return new ConverTableToBeanByOracle();
		} else if (DbUtils.isPgSql()) {
			return new ConverTableToBeanByPg();
		}
		return null;
	}

	/**
	 * 字符串转换大小写
	 * 
	 * @param key key
	 * @return 转换后的 字符串
	 */
	default String convertByDbType(String key) {
		return key;
	};
}
