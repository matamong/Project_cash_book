package com.cash_book.model.outcome;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.cash_book.model.AbstractDAO;
import com.cash_book.model.GetableAttributeNamesDTO;

public class OutcomeDAO extends AbstractDAO {
	
// 생성자
	public OutcomeDAO(Connection connection, GetableAttributeNamesDTO dto) {
		super(connection, dto);
	}
	
// SELECT
	@Override
	public GetableAttributeNamesDTO select(String sql) {
		
		return super.getDTO();
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
