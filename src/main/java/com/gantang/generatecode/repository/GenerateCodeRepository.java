package com.gantang.generatecode.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gantang.generatecode.model.GenerateBean;
import com.gantang.generatecode.model.GenerateProperty;

/**
 * 
 * @author jiangyp
 *
 */
@Repository
public class GenerateCodeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> selectTableName(String tableName) {
		String hql = "select TABLE_NAME FROM all_col_comments GROUP BY (TABLE_NAME,owner)"
				+ " HAVING owner in ('MSTDATA','CFGMGMT','BOMMGMT','CHGMGMT','CUST') and table_name <> 'schema_version' ";
		if (StringUtils.isNotEmpty(tableName)) {
			hql += " and table_name like '" + tableName.trim().toUpperCase() + "%'";
		}
		hql += " order by TABLE_NAME";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(hql.toString());
		return list;
	}

	/**
	 * 加载一个表，转换成一个java对象
	 * 
	 * @param tableNames
	 *            表名称
	 * @return list Bean
	 */
	public List<GenerateBean> loadBean(List<String> tableNames) {
		List<GenerateBean> beans = new ArrayList<>();
		List<Map<String, Object>> list = jdbcTemplate.queryForList(getTableDescSql(tableNames));

		Map<String, List<Map<String, Object>>> bean2Propertys = list.stream()
				.collect(Collectors.groupingBy(it -> it.get("OWNER") + "@" + it.get("TABLE_NAME")));

		for (Entry<String, List<Map<String, Object>>> entry : bean2Propertys.entrySet()) {
			String tableName = entry.getKey().split("@")[1];
			String schemaName = entry.getKey().split("@")[0];
			GenerateBean bean = new GenerateBean(handleBeanName(tableName), tableName, schemaName, loadProperty(entry.getValue(), tableName));
			beans.add(bean);
		}
		return beans;
	}

	protected String getTableDescSql(List<String> tableNames) {
		if (tableNames == null || tableNames.isEmpty()) {
			throw new RuntimeException("请选择要生成代码的表");
		}
		StringBuffer hql = new StringBuffer(
				"select owner,table_name,column_name,data_type,data_length,data_precision,data_scale,nullable from all_tab_columns");
		hql.append(" where table_name in ( ");
		hql.append(tableNames.stream().map(it -> "'" + it + "'").collect(Collectors.joining(",")));
		hql.append(" )");
		return hql.toString();
	}

	/**
	 * 把表名转成类名：BM_PART_ASSEMBLY 转成 PartAssembly
	 * 
	 * @param tableName
	 *            tableName
	 * @return className
	 */
	protected String handleBeanName(String tableName) {
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
	 * 加载一个表中的列变成一个类中的属性
	 * 
	 * @param objects
	 *            所有的列信息
	 * @param tableName
	 *            表名
	 * @return list 属性名
	 */
	protected List<GenerateProperty> loadProperty(List<Map<String, Object>> objects, String tableName) {
		List<GenerateProperty> propertys = new ArrayList<>();
		List<String> filterNames = filterPropertyName();
		for (Map<String, Object> obj : objects) {
			String cloumnName = (String) obj.get("COLUMN_NAME");
			String name = handlePropertyName(cloumnName, tableName);
			if (filterNames.contains(name)) {
				continue;
			}
			Integer length = obj.get("DATA_LENGTH") == null ? null : ((BigDecimal) obj.get("DATA_LENGTH")).intValue();
			Integer precision = obj.get("DATA_PRECISION") == null ? null : ((BigDecimal) obj.get("DATA_PRECISION")).intValue();
			Integer scale = obj.get("DATA_SCALE") == null ? null : ((BigDecimal) obj.get("DATA_SCALE")).intValue();
			GenerateProperty property = new GenerateProperty(name, cloumnName, (String) obj.get("DATA_TYPE"), length, precision, scale,
					(String) obj.get("NULLABLE"));
			propertys.add(property);
		}
		return propertys;
	}

	/**
	 * 不生成属性的字段
	 * 
	 * @return list
	 */
	protected List<String> filterPropertyName() {
		String[] filterNames = { "id", "createdBy", "createDate", "updatedBy", "updateDate", "isDeleted", "deleteDate", "deletedBy", "optCounter" };
		return Arrays.asList(filterNames);
	}

	/**
	 * 把数据库中的列明转成类中的属性名 LINE_NUM 转成 lineNum。如果“列名加_ID” 等于表名直接返回“id”
	 * 
	 * @param cloumnName
	 *            列名
	 * @param tableName
	 *            表名
	 * @return propertyName
	 */
	protected String handlePropertyName(String cloumnName, String tableName) {
		if (cloumnName.equals(tableName + "_ID")) {
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
}
