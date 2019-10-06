package com.cash_book.model.dateList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.CashBookType;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.dbConnection.DBConnection;

public class DateListDTO extends GetableAttributeNamesDTO {
	private String phone;			// VARCHAR2(11)
	private String localDate;		// VARCHAR2(8)
	
	private static final String PHONE_NAME;
	private static final String LOCAL_DATE_NAME;
	
	static {
		PHONE_NAME = "PHONE";
		LOCAL_DATE_NAME = "LOCAL_DATE";
	}
	
	
// 생성자
	public DateListDTO(String _phone, String _localDate) {
		super("DATA_LIST");
		this.phone = _phone;
		this.localDate = _localDate;
	}
	
	
// getter each attribute
	public String getPhone() {
		return phone;
	}
	
	public String getLocalDate() {
		return localDate;
	}
	
	
// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(PHONE_NAME);
		names.add(LOCAL_DATE_NAME);
		
		return names;
	}
	

// getter Values
	@Override
	public Map<String, String> getAttributeValues() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(PHONE_NAME, getPhone());
		values.put(LOCAL_DATE_NAME, getLocalDate());
		
		return values;
	}
	
	
// getter types
	@Override
	public Map<String, CashBookType> getAttributeTypes() {
		Map<String, CashBookType> values = new HashMap<String, CashBookType>();
		values.put(PHONE_NAME, CashBookType.VARCHAR2);
		values.put(LOCAL_DATE_NAME, CashBookType.VARCHAR2);
		
		return values;
	}
	
	
// getter result
	@Override
	public List<GetableAttributeNamesDTO> getResult(ResultSet _resultSet) {
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {
			while(_resultSet.next()) {
				String currentPhone = _resultSet.getString(PHONE_NAME);
				String currentLocalDate = _resultSet.getString(LOCAL_DATE_NAME);
				
				GetableAttributeNamesDTO currentDTO = 
								new DateListDTO(currentPhone, currentLocalDate);
				result.add(currentDTO);
			}
			
		} catch(SQLException e) {
			System.out.println("DateListDTO getResult Err] " + e.getMessage());
			
		} finally {
			DBConnection.close(_resultSet);
		}
		
		return result;
	}
}
