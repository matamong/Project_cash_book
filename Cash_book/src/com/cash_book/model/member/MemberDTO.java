package com.cash_book.model.member;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.GetableAttributeNamesDTO;

public class MemberDTO extends GetableAttributeNamesDTO {
	private String id;
	private String pw;
	private String phone;
	
	public MemberDTO(String _id, String _pw, String _phone) {
		super("MEMBER");
		this.id = _id;
		this.pw = _pw;
		this.phone = _phone;
	}
	
	
	@Override
	public String getTableName() {
		return tableName;
	}
	
	
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add("id");
		names.add("pw");
		names.add("phone");
		
		return names;
	}
	
	
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(id);
		values.add(pw);
		values.add(phone);
		
		return values;
	}
}
