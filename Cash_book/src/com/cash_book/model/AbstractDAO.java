package com.cash_book.model;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO {
	private Connection connection;
	
	
// 생성자
	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}
	
	
// getter connection
	protected Connection getConnection() {
		return connection;
	}
	
	
// SELECT
	abstract public List<GetableAttributeNamesDTO> select(GetableAttributeNamesDTO _dto);
	
// INSERT
	abstract public boolean insert(GetableAttributeNamesDTO _dto);
	
// getter tupleCount
	abstract public int getTupleCount(GetableAttributeNamesDTO _dto);
	
	// getter tupleCount_SQL
	protected String getTupleCount_SQL(String _sql) {
		return _sql.replace("*", "COUNT(*)");		
	}
}
