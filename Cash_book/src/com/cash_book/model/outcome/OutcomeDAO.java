package com.cash_book.model.outcome;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.AbstractDAO;

public class OutcomeDAO extends AbstractDAO {
// SELECT
	@Override
	public List<String> select(String sql) {
		
		return new ArrayList<String>();
	}
	
	
// INSERT
	@Override
	public boolean insert(String sql) {
		
		return true;
	}
	
	
// DELETE
	@Override
	public boolean delete(String sql) {
		
		return true;
	}
}
