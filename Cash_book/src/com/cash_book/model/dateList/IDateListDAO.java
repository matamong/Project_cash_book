package com.cash_book.model.dateList;

public interface IDateListDAO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
