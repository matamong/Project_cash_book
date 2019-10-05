package com.cash_book.model.dateList;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.GetableAttributeNamesDTO;

//Static Factory Method Pattern
//	(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class DateListDTO extends GetableAttributeNamesDTO {
	private String phone;
	private String localDate;	
	
	private static final int PHONE_MAX_LENGTH;
	private static final int LOCAL_DATE_MAX_LENGTH;
	
	static {
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
		return new DateListDTO(_phone, _localDate);
	}
	
	
// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add("PHONE");
		names.add("LOCAL_DATE");
		
		return names;
	}
	

// getter Values
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(phone);
		values.add(localDate);
		
		return values;
	}
}
