package com.cash_book.model.outcome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.Money;

//Static Factory Method Pattern
//	(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class OutcomeDTO extends GetableAttributeNamesDTO {
	private String outcomePhone;
	private String outcomeLocalDate;
	private int outcomeIndex;
	private String outcomeName;
	private Money outcomeAmount;
	private String outcomeMemo;
	
	private static final String OUTCOME_PHONE_NAME;
	private static final String OUTCOME_LOCAL_DATE_NAME;
	private static final String OUTCOME_INDEX_NAME;
	private static final String OUTCOME_NAME_NAME;
	private static final String OUTCOME_AMOUNT_NAME;
	private static final String OUTCOME_MEMO_NAME;
	
	private static final int OUTCOME_PHONE_MAX_LENGTH;
	private static final int OUTCOME_LOCAL_DATE_MAX_LENGTH;
	private static final int OUTCOME_INDEX_MAX_LENGTH;
	private static final int OUTCOME_NAME_MAX_LENGTH;
	private static final int OUTCOME_AMOUNT_MAX_LENGTH;
	private static final int OUTCOME_MEMO_MAX_LENGTH;
	
	static {
		OUTCOME_PHONE_NAME = "OUTCOME_PHONE";
		OUTCOME_LOCAL_DATE_NAME = "OUTCOME_LOCAL_DATE";
		OUTCOME_INDEX_NAME = "OUTCOME_INDEX";
		OUTCOME_NAME_NAME = "OUTCOME_NAME";
		OUTCOME_AMOUNT_NAME = "OUTCOME_AMOUNT";
		OUTCOME_MEMO_NAME = "OUTCOME_MEMO";
		
		OUTCOME_PHONE_MAX_LENGTH = 11;
		OUTCOME_LOCAL_DATE_MAX_LENGTH = 8;
		OUTCOME_INDEX_MAX_LENGTH = 4;
		OUTCOME_NAME_MAX_LENGTH = 50;
		OUTCOME_AMOUNT_MAX_LENGTH = 11;
		OUTCOME_MEMO_MAX_LENGTH = 100;
	}
	
	
// 생성자 
	private OutcomeDTO(String _outcomePhone,
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
	
	
// Instance Factory
	public OutcomeDTO create(String _outcomePhone,
							 String _outcomeLocalDate,
							 String _outcomeIndex,
							 String _outcomeName,
							 String _outcomeAmount,
							 String _outcomeMemo) 
					  throws ClassCastException {
		
		return (_outcomePhone.length() <= OUTCOME_PHONE_MAX_LENGTH)
					&& (_outcomeLocalDate.length() <= OUTCOME_LOCAL_DATE_MAX_LENGTH)
					&& (_outcomeIndex.length() <= OUTCOME_INDEX_MAX_LENGTH)
					&& (_outcomeName.length() <= OUTCOME_NAME_MAX_LENGTH)
					&& (_outcomeAmount.length() <= OUTCOME_AMOUNT_MAX_LENGTH)
					&& (_outcomeMemo.length() <= OUTCOME_MEMO_MAX_LENGTH)
					? new OutcomeDTO(_outcomePhone,
									 _outcomeLocalDate,
									 Integer.parseInt(_outcomeIndex),
									 _outcomeName,
									 Money.wons(_outcomeAmount),
									 _outcomeMemo) : null;
	}
	
	
// getter Names ( List<String> )
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
	
	
// getter Values ( List<String> )
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(outcomePhone);
		values.add(outcomeLocalDate);
		values.add(String.valueOf(outcomeIndex));
		values.add(outcomeName);
		values.add(outcomeAmount.toString());
		values.add(outcomeMemo);
		
		return values;
	}
	
	
// getter Map ( Map<String, String> )
	@Override
	public Map<String, String> getAttributeMap() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(OUTCOME_PHONE_NAME, outcomePhone);
		values.put(OUTCOME_LOCAL_DATE_NAME, outcomeLocalDate);
		values.put(OUTCOME_INDEX_NAME, String.valueOf(outcomeIndex));
		values.put(OUTCOME_NAME_NAME, outcomeName);
		values.put(OUTCOME_AMOUNT_NAME, outcomeAmount.toString());
		values.put(OUTCOME_MEMO_NAME, outcomeMemo);
		
		return values;
	}
}
