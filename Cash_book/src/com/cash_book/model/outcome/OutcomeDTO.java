package com.cash_book.model.outcome;

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

public class OutcomeDTO extends GetableAttributeNamesDTO {
	private String outcomePhone;			// VARCHAR2(11)
	private String outcomeLocalDate;		// VARCHAR2(8)
	private String outcomeName;				// VARCHAR2(50)
	private Money outcomeAmount;			// NUMBER(11)
	private String outcomeMemo;				// VARCHAR2(100)
	
	public static final String OUTCOME_PHONE_NAME;
	public static final String OUTCOME_LOCAL_DATE_NAME;
	public static final String OUTCOME_NAME_NAME;
	public static final String OUTCOME_AMOUNT_NAME;
	public static final String OUTCOME_MEMO_NAME;
	
	static {
		OUTCOME_PHONE_NAME = "OUTCOME_PHONE";
		OUTCOME_LOCAL_DATE_NAME = "OUTCOME_LOCAL_DATE";
		OUTCOME_NAME_NAME = "OUTCOME_NAME";
		OUTCOME_AMOUNT_NAME = "OUTCOME_AMOUNT";
		OUTCOME_MEMO_NAME = "OUTCOME_MEMO";
	}
	
	
// 생성자 
	public OutcomeDTO(String _outcomePhone,
					   String _outcomeLocalDate,
					   String _outcomeName,
					   String _outcomeAmount,
					   String _outcomeMemo) {
		super("OUTCOME");
		this.outcomePhone = checkStringValue(_outcomePhone);
		this.outcomeLocalDate = checkStringValue(_outcomeLocalDate);
		this.outcomeName = checkStringValue(_outcomeName);
		this.outcomeAmount = checkMoneyValue(_outcomeAmount);
		this.outcomeMemo = checkStringValue(_outcomeMemo);
	}
	
	
// getter values for List<String>
	public List<String> getValues() {
		List<String> values = new ArrayList<String>();
		values.add(outcomePhone);
		values.add(outcomeLocalDate);
		values.add(outcomeName);
		values.add(outcomeAmount.toString());
		values.add(outcomeMemo);
		
		return values;
	}
	
	
// getter names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(OUTCOME_PHONE_NAME);
		names.add(OUTCOME_LOCAL_DATE_NAME);
		names.add(OUTCOME_NAME_NAME);
		names.add(OUTCOME_AMOUNT_NAME);
		names.add(OUTCOME_MEMO_NAME);
		
		return names;
	}
	
	
// getter values
	@Override
	public Map<String, String> getAttributeValues() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(OUTCOME_PHONE_NAME, outcomePhone);
		values.put(OUTCOME_LOCAL_DATE_NAME, outcomeLocalDate);
		values.put(OUTCOME_NAME_NAME, outcomeName);
		values.put(OUTCOME_AMOUNT_NAME, outcomeAmount.toString());
		values.put(OUTCOME_MEMO_NAME, outcomeMemo);
		
		return values;
	}
	
	
// getter types
	@Override
	public Map<String, CashBookType> getAttributeTypes() {
		Map<String, CashBookType> types = new HashMap<String, CashBookType>();
		types.put(OUTCOME_PHONE_NAME, CashBookType.STRING);
		types.put(OUTCOME_LOCAL_DATE_NAME, CashBookType.STRING);
		types.put(OUTCOME_NAME_NAME, CashBookType.STRING);
		types.put(OUTCOME_AMOUNT_NAME, CashBookType.MONEY);
		types.put(OUTCOME_MEMO_NAME, CashBookType.STRING);
		
		return types;
	}
	
	
// getter result
	public List<GetableAttributeNamesDTO> getResult(ResultSet _resultSet) {
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {
			while(_resultSet.next()) {
				String currentPhone = _resultSet.getString(OUTCOME_PHONE_NAME);
				String currentLocalDate = _resultSet.getString(OUTCOME_LOCAL_DATE_NAME);
				String currentName = _resultSet.getString(OUTCOME_NAME_NAME);
				Money currentAmount = Money.wons(_resultSet.getInt(OUTCOME_AMOUNT_NAME));
				String currentMemo = _resultSet.getString(OUTCOME_MEMO_NAME);
				
				GetableAttributeNamesDTO currentDTO = 
								new OutcomeDTO(currentPhone, 
											   currentLocalDate, 
											   currentName, 
											   currentAmount.toString(), 
											   currentMemo);
				result.add(currentDTO);
			}
			
		} catch(SQLException e) {
			System.out.println("OutcomeDTO getResult Err] " + e.getMessage());
			
		} finally {
			DBConnection.close(_resultSet);
		}
		
		return result;
	}
}
