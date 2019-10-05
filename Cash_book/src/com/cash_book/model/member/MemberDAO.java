package com.cash_book.model.member;

import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.AbstractDAO;

public class MemberDAO extends AbstractDAO {
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
	public boolean delete(String sql) {
		
		return true;
	}
}
