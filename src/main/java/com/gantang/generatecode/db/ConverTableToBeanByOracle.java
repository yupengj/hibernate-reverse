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
				"select m.owner,m.table_name,m.column_name,m.data_type,m.data_length,m.data_precision,m.data_scale,m.nullable,d.comments ");
		hql.append(" from all_tab_columns m  left join  all_col_comments d on (d.column_name = m.column_name and d.table_name = m.table_name) ");
		hql.append(" where 1=1 ");

		if (selectDbConfig.getSchema() != null && !selectDbConfig.getSchema().isEmpty()) {
			hql.append(buildSqlInWhere("m.owner", selectDbConfig.getSchema(), true));
		} else {
			hql.append(buildSqlInWhere("m.owner", selectDbConfig.getAllowSchema(), true));
		}
		hql.append(buildSqlInWhere("m.table_name", selectDbConfig.getTable(), true));
		hql.append(buildSqlInWhere("m.table_name", selectDbConfig.getIgnoreTable(), false));
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
			String comments = obj.get("comments") == null ? null : obj.get("comments").toString();
			GenerateProperty property = new GenerateProperty(name, cloumnName, comments, (String) obj.get("data_type"), length, precision, scale,
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
