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
	private int outcomeIndex;				// NUMBER(4)
	private String outcomeName;				// VARCHAR2(50)
	private Money outcomeAmount;			// NUMBER(11)
	private String outcomeMemo;				// VARCHAR2(100)
	
	public static final String OUTCOME_PHONE_NAME;
	public static final String OUTCOME_LOCAL_DATE_NAME;
	public static final String OUTCOME_INDEX_NAME;
	public static final String OUTCOME_NAME_NAME;
	public static final String OUTCOME_AMOUNT_NAME;
	public static final String OUTCOME_MEMO_NAME;
	
	static {
		OUTCOME_PHONE_NAME = "OUTCOME_PHONE";
		OUTCOME_LOCAL_DATE_NAME = "OUTCOME_LOCAL_DATE";
		OUTCOME_INDEX_NAME = "OUTCOME_INDEX";
		OUTCOME_NAME_NAME = "OUTCOME_NAME";
		OUTCOME_AMOUNT_NAME = "OUTCOME_AMOUNT";
		OUTCOME_MEMO_NAME = "OUTCOME_MEMO";
	}
	
	
// 생성자 
	public OutcomeDTO(String _outcomePhone,
					   String _outcomeLocalDate,
					   int _outcomeIndex,
					   String _outcomeName,
					   Money _outcomeAmount,
					   String _outcomeMemo) {
		super("OUTCOME");
		this.outcomePhone = _outcomePhone;
		this.outcomeLocalDate = _outcomeLocalDate;
		this.outcomeIndex = _outcomeIndex;
		this.outcomeName = _outcomeName;
		this.outcomeAmount = _outcomeAmount;
		this.outcomeMemo = _outcomeMemo;
	}
	
	
// getter
	public String getOutcomePhone() {
		return outcomePhone;
	}
	
	public String getOutcomeLocalDate() {
		return outcomeLocalDate;
	}
	
	public int getOutcomeIndex() {
		return outcomeIndex;
	}
	
	public String getOutcomeName() {
		return outcomeName;
	}
	
	public Money getOutcomeAmount() {
		return outcomeAmount;
	}
	
	public String getOutcomeMemo() {
		return outcomeMemo;
	}
	
	
// getter values for List<String>
	public List<String> getValues() {
		List<String> values = new ArrayList<String>();
		values.add(getOutcomePhone());
		values.add(getOutcomeLocalDate());
		values.add(String.valueOf(getOutcomeIndex()));
		values.add(getOutcomeName());
		values.add(getOutcomeAmount().toString());
		values.add(getOutcomeMemo());
		
		return values;
	}
	
	
// getter names
	@Override
	public List<String> getAttributeNames() {
		List<String> names = new ArrayList<String>();
		names.add(OUTCOME_PHONE_NAME);
		names.add(OUTCOME_LOCAL_DATE_NAME);
		names.add(OUTCOME_INDEX_NAME);
		names.add(OUTCOME_NAME_NAME);
		names.add(OUTCOME_AMOUNT_NAME);
		names.add(OUTCOME_MEMO_NAME);
		
		return names;
	}
	
	
// getter values
	@Override
	public Map<String, String> getAttributeValues() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(OUTCOME_PHONE_NAME, getOutcomePhone());
		values.put(OUTCOME_LOCAL_DATE_NAME, getOutcomeLocalDate());
		values.put(OUTCOME_INDEX_NAME, String.valueOf(getOutcomeIndex()));
		values.put(OUTCOME_NAME_NAME, getOutcomeName());
		values.put(OUTCOME_AMOUNT_NAME, getOutcomeAmount().toString());
		values.put(OUTCOME_MEMO_NAME, getOutcomeMemo());
		
		return values;
	}
	
	
// getter types
	@Override
	public Map<String, CashBookType> getAttributeTypes() {
		Map<String, CashBookType> types = new HashMap<String, CashBookType>();
		types.put(OUTCOME_PHONE_NAME, CashBookType.VARCHAR2);
		types.put(OUTCOME_LOCAL_DATE_NAME, CashBookType.VARCHAR2);
		types.put(OUTCOME_INDEX_NAME, CashBookType.NUMBER);
		types.put(OUTCOME_NAME_NAME, CashBookType.VARCHAR2);
		types.put(OUTCOME_AMOUNT_NAME, CashBookType.NUMBER);
		types.put(OUTCOME_MEMO_NAME, CashBookType.VARCHAR2);
		
		return types;
	}
	
	
// getter result
	public List<GetableAttributeNamesDTO> getResult(ResultSet _resultSet) {
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {
			while(_resultSet.next()) {
				String currentPhone = _resultSet.getString(OUTCOME_PHONE_NAME);
				String currentLocalDate = _resultSet.getString(OUTCOME_LOCAL_DATE_NAME);
				int currentIndex = _resultSet.getInt(OUTCOME_INDEX_NAME);
				String currentName = _resultSet.getString(OUTCOME_NAME_NAME);
				Money currentAmount = Money.wons(_resultSet.getInt(OUTCOME_AMOUNT_NAME));
				String currentMemo = _resultSet.getString(OUTCOME_MEMO_NAME);
				
				GetableAttributeNamesDTO currentDTO = 
								new OutcomeDTO(currentPhone, 
											   currentLocalDate, 
											   currentIndex, 
											   currentName, 
											   currentAmount, 
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
