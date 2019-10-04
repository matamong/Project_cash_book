package com.cash_book.model;

import java.util.List;

public abstract class GetableAttributeNamesDTO {
	protected String tableName;
	
	
// 생성자
	public GetableAttributeNamesDTO(String _tableName) {
		this.tableName = _tableName;
	}
	
	
// Getter tableName
	abstract public String getTableName();
	
// Getter attributeNames
	abstract public List<String> getAttributeNames();
	
// Getter attributeValues
	abstract public List<String> getAttributeValues();
}
