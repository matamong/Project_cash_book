package com.cash_book.controller.dateList;

public interface IDateListDTO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
