package com.cash_book.model;

import java.util.List;
import java.util.Map;

public abstract class GetableAttributeNamesDTO {
	private String tableName;
	
	
// 생성자
	protected GetableAttributeNamesDTO(String _tableName) {
		this.tableName = _tableName;
	}
	
	
// getter tableName
	public String getTableName() {
		return tableName;
	}
	
// getter attributeNames
	abstract public List<String> getAttributeNames();
	
// getter attributeValues
	abstract public List<String> getAttributeValues();
	
// getter attributeMap
	abstract public Map<String, String> getAttributeMap();
}
