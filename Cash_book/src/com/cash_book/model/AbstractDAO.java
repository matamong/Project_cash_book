package com.cash_book.model;

import java.sql.Connection;
import java.util.List;

import com.cash_book.model.dbConnection.DBConnection;

public abstract class AbstractDAO {
	private Connection connection;
	private GetableAttributeNamesDTO dto;
	
	
// 생성자
	public AbstractDAO(Connection connection, GetableAttributeNamesDTO dto) {
		this.connection = connection;
		this.dto = dto;
	}
	
	
// getter connection
	protected Connection getConnection() {
		return connection;
	}
	

// getter dto
	protected GetableAttributeNamesDTO getDTO() {
		return dto;
	}
	
	
// getter attributeNames
	protected List<String> getAttributeNames() {
		return dto.getAttributeNames();
	}
	

// SELECT
	abstract public GetableAttributeNamesDTO select(String _sql);
	
// INSERT
	abstract public boolean insert(String sql);
	
// DELETE
	abstract public boolean delete(String sql);
}
