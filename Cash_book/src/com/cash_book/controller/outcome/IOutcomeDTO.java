package com.cash_book.controller.outcome;

public interface IOutcomeDTO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
