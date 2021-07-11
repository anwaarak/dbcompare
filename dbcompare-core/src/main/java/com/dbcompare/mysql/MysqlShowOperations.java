package com.dbcompare.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MysqlShowOperations {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> showDatabaseList() {
		String sql = "SHOW DATABASES";
		List<String> response = jdbcTemplate.queryForList(sql, String.class);
		return response;
	}
	
	public String showGrantForUser(String user) {
		String sql = "SHOW GRANTS FOR "+user;
		String grantScriptForUser = jdbcTemplate.queryForObject(sql, String.class);
		return grantScriptForUser;
	}
}
