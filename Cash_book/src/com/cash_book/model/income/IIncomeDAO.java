package com.cash_book.model.income;

public interface IIncomeDAO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
