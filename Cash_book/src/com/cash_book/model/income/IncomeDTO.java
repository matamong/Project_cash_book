package com.cash_book.model.income;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cash_book.model.GetableAttributeNamesDTO;
import com.cash_book.model.Money;

//Static Factory Method Pattern
//	(DTO 필드변수 자료형의 정보은닉을 위한 목적)
public class IncomeDTO extends GetableAttributeNamesDTO {
	private String incomePhone;			// VARCHAR2(11)
	private String incomeLocalDate;		// VARCHAR2(8)
	private int incomeIndex;			// NUMBER(4)
	private String incomeName;			// VARCHAR2(50)
	private Money incomeAmount;			// NUMBER(11)
	private String incomeMemo;			// VARCHAR2(100)
	
	private static final String INCOME_PHONE_NAME;
	private static final String INCOME_LOCAL_DATE_NAME;
	private static final String INCOME_INDEX_NAME;
	private static final String INCOME_NAME_NAME;
	private static final String INCOME_AMOUNT_NAME;
	private static final String INCOME_MEMO_NAME;
	
	private static final int INCOME_PHONE_MAX_LENGTH;
	private static final int INCOME_LOCAL_DATE_MAX_LENGTH;
	private static final int INCOME_INDEX_MAX_LENGTH;
	private static final int INCOME_NAME_MAX_LENGTH;
	private static final int INCOME_AMOUNT_MAX_LENGTH;
	private static final int INCOME_MEMO_MAX_LENGTH;
	
	static {
		INCOME_PHONE_NAME = "INCOME_PHONE";
		INCOME_LOCAL_DATE_NAME = "INCOME_LOCAL_DATE";
		INCOME_INDEX_NAME = "INCOME_INDEX";
		INCOME_NAME_NAME = "INCOME_NAME";
		INCOME_AMOUNT_NAME = "INCOME_AMOUNT";
		INCOME_MEMO_NAME = "INCOME_MEMO";
		
		INCOME_PHONE_MAX_LENGTH = 11;
		INCOME_LOCAL_DATE_MAX_LENGTH = 8;
		INCOME_INDEX_MAX_LENGTH = 4;
		INCOME_NAME_MAX_LENGTH = 50;
		INCOME_AMOUNT_MAX_LENGTH = 11;
		INCOME_MEMO_MAX_LENGTH = 100;
	}
	
	
// 생성자
	private IncomeDTO(String _incomePhone,
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
	
	
// Instance Factory
	public IncomeDTO create(String _incomePhone,
							String _incomeLocalDate,
							String _incomeIndex,
							String _incomeName,
							String _incomeAmount,
							String _incomeMemo) 
					 throws ClassCastException {
		
		return (_incomePhone.length() <= INCOME_PHONE_MAX_LENGTH)
					&& (_incomeLocalDate.length() <= INCOME_LOCAL_DATE_MAX_LENGTH)
					&& (_incomeIndex.length() <= INCOME_INDEX_MAX_LENGTH)
					&& (_incomeName.length() <= INCOME_NAME_MAX_LENGTH)
					&& (_incomeAmount.length() <= INCOME_AMOUNT_MAX_LENGTH)
					&& (_incomeMemo.length() <= INCOME_MEMO_MAX_LENGTH)
					? new IncomeDTO(_incomePhone,
									_incomeLocalDate,
									Integer.parseInt(_incomeIndex),
									_incomeName,
									Money.wons(_incomeAmount),
									_incomeMemo) : null;
	}
	
	
// getter Names ( List<String> )
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
	
	
// getter values  ( List<String> )
	@Override
	public List<String> getAttributeValues() {
		List<String> values = new ArrayList<String>();
		values.add(incomePhone);
		values.add(incomeLocalDate);
		values.add(String.valueOf(incomeIndex));
		values.add(incomeName);
		values.add(incomeAmount.toString());
		values.add(incomeMemo);
		
		return values;
	}
	
	
// getter Map ( Map<String, String> ) *** List 보다 Map으로 반환이 좋은 듯..
	@Override
	public Map<String, String> getAttributeMap() {
		Map<String, String> values = new HashMap<String, String>();
		values.put(INCOME_PHONE_NAME, incomePhone);
		values.put(INCOME_LOCAL_DATE_NAME, incomeLocalDate);
		values.put(INCOME_INDEX_NAME, String.valueOf(incomeIndex));
		values.put(INCOME_NAME_NAME, incomeName);
		values.put(INCOME_AMOUNT_NAME, incomeAmount.toString());
		values.put(INCOME_MEMO_NAME, incomeMemo);
		
		return values;
	}
}
