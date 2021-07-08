package com.dbcompare.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MysqlService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> getTables() {
		String sql = "show tables";
		List<String> tables = jdbcTemplate.queryForList(sql, String.class);
		return tables;
	}
	
	public String getTableDDL(String table) {
		String sql = "SHOW CREATE TABLE "+table;
		List<String> tables = jdbcTemplate.query(
	                sql,
	                (rs, rowNum) -> rs.getString(2)
	                        
	        );
		return tables.get(0);
	}
}
