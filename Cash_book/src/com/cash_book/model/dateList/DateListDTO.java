package com.cash_book.model.dateList;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.GetableAttributeNamesDTO;

//Static Factory Method Pattern
//	(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class DateListDTO extends GetableAttributeNamesDTO {
	private String date;
	private String phone;
	
	
// 생성자
	private DateListDTO(String _date, String _phone) {
		super("DATA_LIST");
		this.date = _date;
		this.phone = _phone;
	}
	
	
// Instance Factory
	public static DateListDTO create(String _date, String _phone) {
		return new DateListDTO(_date, _phone);
	}
	
	
// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add("date");
		names.add("phone");
		
		return names;
	}
	

// getter Values
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(date);
		values.add(phone);
		
		return values;
	}
}
