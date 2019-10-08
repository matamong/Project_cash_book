package com.cash_book.model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.CashBookType;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.dbConnection.DBConnection;

public class MemberDTO extends GetableAttributeNamesDTO {
	private String phone;		// VARCHAR2(11)
	private String name;		// VARCHAR2(10)
	private String pw;			// VARCHAR2(15)
	
	public static final String PHONE_NAME;
	public static final String NAME_NAME;
	public static final String PW_NAME;
	
	static {
		PHONE_NAME = "PHONE";
		NAME_NAME = "NAME";
		PW_NAME = "PW";
	}

	
// 생성자
	public MemberDTO(String _phone, String _name, String _pw) {
		super("MEMBER");
		this.phone = checkStringValue(_phone);
		this.name = checkStringValue(_name);
		this.pw = checkStringValue(_pw);
	}
	
	
// getter values for List<String>
	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<String>();
		values.add(phone);
		values.add(name);
		values.add(pw);
		
		return values;
	}
	

// getter names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(PHONE_NAME);
		names.add(NAME_NAME);
		names.add(PW_NAME);
		
		return names;
	}
	
	
// getter values
	@Override
	public Map<String, String> getAttributeValues() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(PHONE_NAME, phone);
		values.put(NAME_NAME, name);
		values.put(PW_NAME, pw);
		
		return values;
	}

	
// getter types
	@Override
	public Map<String, CashBookType> getAttributeTypes() {
		Map<String, CashBookType> types = new HashMap<String, CashBookType>();
		types.put(PHONE_NAME, CashBookType.STRING);
		types.put(NAME_NAME, CashBookType.STRING);
		types.put(PW_NAME, CashBookType.STRING);
		
		return types;
	}
	
	
// getter result
	@Override
	public List<GetableAttributeNamesDTO> getResult(ResultSet _resultSet) {
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {			
			while(_resultSet.next()) {
				String currentPhone = _resultSet.getString(PHONE_NAME);
				String currentName = _resultSet.getString(NAME_NAME);
				String currentPw = _resultSet.getString(PW_NAME);

				GetableAttributeNamesDTO currentDTO = 
								new MemberDTO(currentPhone, currentName, currentPw);
				result.add(currentDTO);
			}
		
		} catch(SQLException e) {
			System.out.println("MemberDTO getResult Err] " + e.getMessage());
			
		} finally {
			DBConnection.close(_resultSet);
		}
		
		return result;
	}
}
