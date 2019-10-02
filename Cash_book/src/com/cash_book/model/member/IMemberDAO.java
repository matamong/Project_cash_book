package com.cash_book.model.member;

public interface IMemberDAO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
