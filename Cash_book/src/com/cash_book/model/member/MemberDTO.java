package com.cash_book.model.member;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.GetableAttributeNamesDTO;

// Static Factory Method Pattern
// 		(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class MemberDTO extends GetableAttributeNamesDTO {
	private String phone;
	private String name;
	private String pw;
	
	private static final int PHONE_MAX_LENGTH;
	private static final int NAME_MAX_LENGTH;
	private static final int PW_MAX_LENGTH;
	
	static {
		PHONE_MAX_LENGTH = 11;
		NAME_MAX_LENGTH = 10;
		PW_MAX_LENGTH = 15;
	}
	
// 생성자
	private MemberDTO(String _phone, String _name, String _pw) {
		super("MEMBER");
		this.phone = _phone;
		this.name = _name;
		this.pw = _pw;
	}
	
	
// Instance Factory
	public static MemberDTO create(String _phone, String _name, String _pw) {
		return (_phone.length() > PHONE_MAX_LENGTH) 
					&& (_name.length() > NAME_MAX_LENGTH)
					&& (_pw.length() > PW_MAX_LENGTH)
					? new MemberDTO(_phone, _name, _pw) : null;
	}


// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add("PHONE");
		names.add("NAME");
		names.add("PW");
		
		return names;
	}
	
	
// getter Values
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(phone);
		values.add(name);
		values.add(pw);
		
		return values;
	}
}
