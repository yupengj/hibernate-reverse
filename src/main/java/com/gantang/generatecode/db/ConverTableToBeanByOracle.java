package com.gantang.generatecode.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gantang.generatecode.config.SelectDbConfig;
import com.gantang.generatecode.model.GenerateProperty;

/**
 * 
 * @author jiangyp
 *
 */
public class ConverTableToBeanByOracle implements ConverTableToBean {

	// select * from all_col_comments where TABLE_NAME = 'BM_PART_ASSEMBLY'
	public String selectTableColumnSql(SelectDbConfig selectDbConfig) {
		StringBuffer hql = new StringBuffer(
				"select owner,table_name,column_name,data_type,data_length,data_precision,data_scale,nullable from all_tab_columns");
		hql.append(" where 1=1 ");

		if (selectDbConfig.getSchema() != null && !selectDbConfig.getSchema().isEmpty()) {
			hql.append(buildSqlInWhere("owner", selectDbConfig.getSchema(), true));
		} else {
			hql.append(buildSqlInWhere("owner", selectDbConfig.getAllowSchema(), true));
		}
		hql.append(buildSqlInWhere("table_name", selectDbConfig.getTable(), true));
		hql.append(buildSqlInWhere("table_name", selectDbConfig.getIgnoreTable(), false));
		return hql.toString();
	}

	/**
	 * 加载一个表中的列变成一个类中的属性
	 * 
	 * @param objects   所有的列信息
	 * @param tableName 表名
	 * @return list 属性名
	 */
	public List<GenerateProperty> loadProperty(List<Map<String, Object>> objects, String tableName) {
		List<GenerateProperty> propertys = new ArrayList<>();
		List<String> filterNames = filterPropertyName();
		for (Map<String, Object> obj : objects) {
			String cloumnName = (String) obj.get("column_name");
			String name = handlePropertyName(cloumnName, tableName);
			if (filterNames.contains(name)) {
				continue;
			}
			Integer length = obj.get("data_length") == null ? null : ((BigDecimal) obj.get("data_length")).intValue();
			Integer precision = obj.get("data_precision") == null ? null : ((BigDecimal) obj.get("data_precision")).intValue();
			Integer scale = obj.get("dtat_scale") == null ? null : ((BigDecimal) obj.get("dtat_scale")).intValue();
			GenerateProperty property = new GenerateProperty(name, cloumnName, (String) obj.get("data_type"), length, precision, scale,
					(String) obj.get("number"));
			propertys.add(property);
		}
		return propertys;
	}

	@Override
	public String convertByDbType(String key) {
		return key.toUpperCase();
	}
}
