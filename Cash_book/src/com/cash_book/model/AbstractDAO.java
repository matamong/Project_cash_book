package com.cash_book.model;

import java.sql.Connection;
import java.util.List;

import com.cash_book.model.dbConnection.DBConnection;

public abstract class AbstractDAO {
	private Connection connection;
	
	
// 생성자
	public AbstractDAO() {
		this.connection = DBConnection.getConnection();
	}
	

// SELECT
	abstract public List<String> select(String _sql);
	
// INSERT
	abstract public boolean insert(String sql);
	
// DELETE
	abstract public boolean delete(String sql);
}
