package com.cash_book.model.income;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.CashBookType;
import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.Money;
import com.cash_book.model.dbConnection.DBConnection;

public class IncomeDTO extends GetableAttributeNamesDTO {
	private String incomePhone;			// VARCHAR2(11)
	private String incomeLocalDate;		// VARCHAR2(8)
	private int incomeIndex;			// NUMBER(4)
	private String incomeName;			// VARCHAR2(50)
	private Money incomeAmount;			// NUMBER(11)
	private String incomeMemo;			// VARCHAR2(100)
	
	public static final String INCOME_PHONE_NAME;
	public static final String INCOME_LOCAL_DATE_NAME;
	public static final String INCOME_INDEX_NAME;
	public static final String INCOME_NAME_NAME;
	public static final String INCOME_AMOUNT_NAME;
	public static final String INCOME_MEMO_NAME;
	
	static {
		INCOME_PHONE_NAME = "INCOME_PHONE";
		INCOME_LOCAL_DATE_NAME = "INCOME_LOCAL_DATE";
		INCOME_INDEX_NAME = "INCOME_INDEX";
		INCOME_NAME_NAME = "INCOME_NAME";
		INCOME_AMOUNT_NAME = "INCOME_AMOUNT";
		INCOME_MEMO_NAME = "INCOME_MEMO";
	}
	
	
// 생성자
	public IncomeDTO(String _incomePhone,
					  String _incomeLocalDate,
					  int _incomeIndex,
					  String _incomeName,
					  Money _incomeAmount,
					  String _incomeMemo) {
		super("INCOME");
		this.incomePhone = _incomePhone;
		this.incomeLocalDate = _incomeLocalDate;
		this.incomeIndex = _incomeIndex;
		this.incomeName = _incomeName;
		this.incomeAmount = _incomeAmount;
		this.incomeMemo = _incomeMemo;
	}
	
	
// getter Names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(INCOME_PHONE_NAME);
		names.add(INCOME_LOCAL_DATE_NAME);
		names.add(INCOME_INDEX_NAME);
		names.add(INCOME_NAME_NAME);
		names.add(INCOME_AMOUNT_NAME);
		names.add(INCOME_MEMO_NAME);
		
		return names;
	}
	
	
// getter values for List<String>
	@Override
	public List<String> getValues() {
		List<String> values = new ArrayList<String>();
		values.add(incomePhone);
		values.add(incomeLocalDate);
		values.add(String.valueOf(incomeIndex));
		values.add(incomeName);
		values.add(incomeAmount.toString());
		values.add(incomeMemo);
		
		return values;
	}
	
	
// getter values
	@Override
	public Map<String, String> getAttributeValues() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(INCOME_PHONE_NAME, incomePhone);
		values.put(INCOME_LOCAL_DATE_NAME, incomeLocalDate);
		values.put(INCOME_INDEX_NAME, String.valueOf(incomeIndex));
		values.put(INCOME_NAME_NAME, incomeName);
		values.put(INCOME_AMOUNT_NAME, incomeAmount.toString());
		values.put(INCOME_MEMO_NAME, incomeMemo);		
		
		return values;
	}
	
	
// getter types
	@Override
	public Map<String, CashBookType> getAttributeTypes() {
		Map<String, CashBookType> types = new HashMap<String, CashBookType>();
		types.put(INCOME_PHONE_NAME, CashBookType.VARCHAR2);
		types.put(INCOME_LOCAL_DATE_NAME, CashBookType.VARCHAR2);
		types.put(INCOME_INDEX_NAME, CashBookType.NUMBER);
		types.put(INCOME_NAME_NAME, CashBookType.VARCHAR2);
		types.put(INCOME_AMOUNT_NAME, CashBookType.NUMBER);
		types.put(INCOME_MEMO_NAME, CashBookType.VARCHAR2);
		
		return types;
	}
	
	
// getter result
	@Override
	public List<GetableAttributeNamesDTO> getResult(ResultSet _resultSet) {
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {
			while(_resultSet.next()) {
				String currentPhone = _resultSet.getString(INCOME_PHONE_NAME);
				String currentLocalDate = _resultSet.getString(INCOME_LOCAL_DATE_NAME);
				int currentIndex = _resultSet.getInt(INCOME_INDEX_NAME);
				String currentName = _resultSet.getString(INCOME_NAME_NAME);
				Money currentAmount = Money.wons(_resultSet.getString(INCOME_AMOUNT_NAME));
				String currentMemo = _resultSet.getString(INCOME_MEMO_NAME);
				
				GetableAttributeNamesDTO currentDTO = 
								new IncomeDTO(currentPhone, 
											  currentLocalDate, 
											  currentIndex, 
											  currentName, 
											  currentAmount, 
											  currentMemo);
				result.add(currentDTO);
			}
			
		} catch(SQLException e) {
			System.out.println("IncomeDTO getResult Err] " + e.getMessage());
			
		} finally {
			DBConnection.close(_resultSet);
		}
		
		return result;
	}
}
