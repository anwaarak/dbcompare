package com.dbcompare;

import java.util.List;

public interface DBDDLOperations {

	public List<String> getTables();
	public List<String> getViews();
	public List<String> getStoredProcedures();
	
}
