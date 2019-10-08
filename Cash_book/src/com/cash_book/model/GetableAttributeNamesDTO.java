package com.cash_book.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public abstract class GetableAttributeNamesDTO {
	private String tableName;
	
	
// 생성자
	protected GetableAttributeNamesDTO(String _tableName) {
		this.tableName = _tableName;
	}
	
	// check String value
	protected String checkStringValue(String _val) {
		if(_val == null || _val.equals("") || _val.equals("0")) {
			return " ";
		}
		
		return _val;
	}
	
	// check Money value
	protected Money checkMoneyValue(String _val) {
		if(_val == null || _val.equals("") || _val.equals("0")) {
			return Money.ZERO;
		}
		
		return Money.wons(_val);
	}
	
	
// getter tableName
	public String getTableName() {
		return tableName;
	}
	
// getter getValues for List<String>
	abstract public List<String> getValues();
	
// getter attributeNames
	abstract public List<String> getAttributeNames();
	
// getter attributeValues
	abstract public Map<String, String> getAttributeValues();
	
// getter attributeTypeMap
	abstract public Map<String, CashBookType> getAttributeTypes();
	
// getter result
	abstract public List<GetableAttributeNamesDTO> getResult(ResultSet resultSet);
}
