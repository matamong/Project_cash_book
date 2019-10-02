package com.cash_book.controller.member;

public interface IMemberDTO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
