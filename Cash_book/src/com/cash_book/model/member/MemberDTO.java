package com.cash_book.model.member;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.GetableAttributeNamesDTO;

// Static Factory Method Pattern
// 		(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class MemberDTO extends GetableAttributeNamesDTO {
	private String id;
	private String pw;
	private String phone;
	
	
// 생성자
	private MemberDTO(String _id, String _pw, String _phone) {
		super("MEMBER");
		this.id = _id;
		this.pw = _pw;
		this.phone = _phone;
	}
	
	
// Instance Factory
	public static MemberDTO create(String _id, String _pw, String _phone) {
		return new MemberDTO(_id, _pw, _phone);
	}


// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add("id");
		names.add("pw");
		names.add("phone");
		
		return names;
	}
	
	
// getter Values
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(id);
		values.add(pw);
		values.add(phone);
		
		return values;
	}
}
