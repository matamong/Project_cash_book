package com.cash_book.model.dateList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.GetableAttributeNamesDTO;

//Static Factory Method Pattern
//	(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class DateListDTO extends GetableAttributeNamesDTO {
	private String phone;
	private String localDate;	
	
	private static final String PHONE_NAME;
	private static final String LOCAL_DATE_NAME;
	
	private static final int PHONE_MAX_LENGTH;
	private static final int LOCAL_DATE_MAX_LENGTH;
	
	static {
		PHONE_NAME = "PHONE";
		LOCAL_DATE_NAME = "LOCAL_DATE";
		
		PHONE_MAX_LENGTH = 11;
		LOCAL_DATE_MAX_LENGTH = 8;
	}
	
	
// 생성자
	private DateListDTO(String _phone, String _localDate) {
		super("DATA_LIST");
		this.phone = _phone;
		this.localDate = _localDate;
	}
	
	
// Instance Factory
	public static DateListDTO create(String _phone, String _localDate) {
		return (_phone.length() <= PHONE_MAX_LENGTH)
					&& (_localDate.length() <= LOCAL_DATE_MAX_LENGTH)
					? new DateListDTO(_phone, _localDate) : null;
	}
	
	
// getter Names ( List<String> )
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(PHONE_NAME);
		names.add(LOCAL_DATE_NAME);
		
		return names;
	}
	

// getter Values ( List<String> )
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(phone);
		values.add(localDate);
		
		return values;
	}
	
	
// getter Map ( Map<String, String> )
	@Override
	public Map<String, String> getAttributeMap() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(PHONE_NAME, phone);
		values.put(LOCAL_DATE_NAME, localDate);
		
		return values;
	}
}
