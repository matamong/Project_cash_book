package com.cash_book.controller.income;

public interface IIncomeDTO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
