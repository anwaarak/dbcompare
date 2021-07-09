package com.dbcompare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbcompare.mysql.MysqlService;

@RestController
public class MysqlController {

	@Autowired
	private MysqlService service;
	
	@GetMapping("/tables")
	public ResponseEntity<?> getTables() {
	    return new ResponseEntity<List<String>>(service.getTables(), HttpStatus.OK);
	}
	
	@GetMapping("/ddl/{tableName}")
	public ResponseEntity<?> getTableDDL(@PathVariable String tableName) {
	    return new ResponseEntity<String>(service.getTableDDL(tableName), HttpStatus.OK);
	}
	
	@GetMapping("/information_schema/table")
	public ResponseEntity<?> getTableDetailsFromInformationSchema() {
	    return new ResponseEntity<List<Object[]>>(service.getFullTableDetailFromInformationSchema(), HttpStatus.OK);
	}
	
	@GetMapping("/information_schema/column")
	public ResponseEntity<?> getColumnDetailsFromInformationSchema() {
	    return new ResponseEntity<List<Object[]>>(service.getFullColumnDetailFromInformationSchema(), HttpStatus.OK);
	}
}
