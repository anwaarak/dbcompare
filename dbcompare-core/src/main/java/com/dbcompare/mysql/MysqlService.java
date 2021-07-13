package com.dbcompare.mysql;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MysqlService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> findAllTablesInDB() {
		String sql = "SHOW TABLES";
		List<String> tables = jdbcTemplate.queryForList(sql, String.class);
		return tables;
	}
	
	public String getCreateTableDDLScriptFor(String table) {
		String sql = "SHOW CREATE TABLE "+table;
		List<String> tables = jdbcTemplate.query(sql,(rs, rowNum) -> rs.getString(2));
		return tables.get(0);
	}
	
	public String getDropCreateTableDDLScriptFor(String table) {
		String sql = "SHOW CREATE TABLE "+table;
		List<String> tables = jdbcTemplate.query(sql,(rs, rowNum) -> rs.getString(2));
		return tables.get(0);
	}
	
	
	
	
	public String getViewDDL(String viewName) {
		String sql = "SHOW CREATE VIEW "+viewName;
		List<String> tables = jdbcTemplate.query(sql,(rs, rowNum) -> rs.getString(2));
		return tables.get(0);
	}
	
	public List<Object[]> getFullTableDetailFromInformationSchema() {
		String query = "SELECT * FROM information_schema.tables";
		List<Object[]> result = jdbcTemplate.queryForList(query).stream().map(row -> row.values().toArray()).collect(Collectors.toList());
		return result;
	}
	
	
	public List<Object[]> getFullColumnDetailFromInformationSchema() {
		String query = "SELECT * FROM information_schema.COLUMNS";
		List<Object[]> result = jdbcTemplate.queryForList(query).stream().map(row -> row.values().toArray()).collect(Collectors.toList());
		return result;
	}
	
	
	
}
