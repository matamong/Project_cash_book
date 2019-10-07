package com.cash_book.model.outcome;

public interface IOutcomeDAO {
	public String[] select(String sql);
	public boolean insert(String sql);
	public boolean delete(String sql);
}
