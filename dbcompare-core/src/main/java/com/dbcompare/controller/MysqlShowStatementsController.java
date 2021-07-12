package com.dbcompare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbcompare.mysql.MysqlShowOperations;

@RestController
public class MysqlShowStatementsController {
	
	@Autowired
	private MysqlShowOperations showOperations;
	
	@GetMapping("/mysql/show/grant/{user}")
	public ResponseEntity<?> getUserGrant(@PathVariable String user) {
	    return new ResponseEntity<String>(showOperations.showGrantForUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/mysql/show/database")
	public ResponseEntity<?> getDatabaseList() {
	    return new ResponseEntity<List<String>>(showOperations.showDatabaseList(), HttpStatus.OK);
	}

}
