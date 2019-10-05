package com.cash_book.model;

import java.math.BigInteger;

// Static Factory Method Pattern
public class Money {
	private BigInteger amount;
	
	public static final Money ZERO;
	
	static {
		ZERO = Money.wons(0);
	}
	
	
// 생성자
	private Money(BigInteger _amount) {
		this.amount = _amount;
	}
	

// Instance Factory for long type
	public static Money wons(long _amount) {
		return new Money(BigInteger.valueOf(_amount));
	}
	
	
// Instance Factory for int type
	public static Money wons(int _amount) {
		return new Money(BigInteger.valueOf(_amount));
	}
	
	
// Instance Factory for String type
	public static Money wons(String _amount) throws ClassCastException {
		return new Money(BigInteger.valueOf(Long.parseLong(_amount)));
	}
	
	
// plus Calculate
	public Money plus(Money ...amounts) {
		BigInteger result = this.amount;
		
		for(Money money : amounts) {
			result = result.add(money.amount);
		}
		
		return new Money(result);
	}
	
	
// minus Calculate
	public Money minus(Money ...amounts) {
		BigInteger result = this.amount;
		
		for(Money money : amounts) {
			result = result.subtract(money.amount);
		}
		
		return new Money(result);
	}
	
	
// divide Calculate
	public Money divide(int divisor) {
		return new Money(this.amount.divide(BigInteger.valueOf(divisor)));
	}
	
	
// avg Calculate
	public static Money avg(Money ...amounts) {
		Money result = Money.ZERO;
		result = result.plus(amounts).divide(amounts.length);
		
		return result;
	}
	
	
	@Override
	public String toString() {
		return amount.toString();
	}
}
