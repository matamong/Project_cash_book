package com.cash_book.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cash_book.model.dbConnection.DBConnection;

public class CashBookDAO extends AbstractDAO {
	
	
// 생성자
	public CashBookDAO(/*Connection connection*/) {
//		super(connection);
	}
	
	
// SELECT
	@Override
	public List<GetableAttributeNamesDTO> select(GetableAttributeNamesDTO _dto) {
		String sql = "SELECT * FROM " + _dto.getTableName();

		Map<String, String> values = _dto.getAttributeValues();
		Map<String, CashBookType> types = _dto.getAttributeTypes();
		
		sql = sql.concat(createSQL_where(values, types));
		
		Statement statement = null;
		ResultSet resultSet = null;
		List<GetableAttributeNamesDTO> result = new ArrayList<GetableAttributeNamesDTO>();
		
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery(sql);
			
			result = _dto.getResult(resultSet);

		} catch(SQLException e) {
			System.out.println("SELECT Err] " + e);
			
		} finally {
			DBConnection.close(statement);
			DBConnection.close(resultSet);
		}
		
		return result;
	}
	
	
	// create SQL WHERE
	private String createSQL_where(Map<String, String> _conditions, 
								   Map<String, CashBookType> _types) {
		String sql = "";
		
		Set<String> keys = _conditions.keySet();
		Iterator<String> iterator = keys.iterator();	
		
		while(iterator.hasNext()) {
			String currentKey = iterator.next();
			String currentValue = _conditions.get(currentKey);
			
			if(currentValue != null || currentValue != "") {
				switch(_types.get(currentKey)) {
				case VARCHAR2:
					sql = sql.concat(" AND " + currentKey + " = '" + currentValue + "'");
					break;
					
				case NUMBER:
					sql = sql.concat(" AND " + currentKey + " = " + currentValue);
				}
			}
		}
		
		sql = sql.replaceFirst("AND", "WHERE");
		return sql;
	}
	
	
// INSERT
	@Override
	public boolean insert(GetableAttributeNamesDTO _dto) {
		int result = 0;
		
		Map<String, String> values = _dto.getAttributeValues();
		Map<String, CashBookType> types = _dto.getAttributeTypes();
		
		String sql = "INSERT INTO " + _dto.getTableName();
		sql = sql.concat(createSQL_into(values, types));
		sql = sql.concat(createSQL_values(values, types));
		
		Statement statement = null;
		
		try {
			statement = getConnection().createStatement();
			result = statement.executeUpdate(sql);
			
		} catch(SQLException e) {
			System.out.println("INSERT Err] " + e.getMessage());
			
		} finally {
			DBConnection.close(statement);
		}
		
		if(result > 0) {
			return true;
			
		} else {
			return false;
		}
	}
	
	
	// create SQL INTO
	private String createSQL_into(Map<String, String> values,
								  Map<String, CashBookType> types) {
		String sql = "";
		
		Set<String> keys = values.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String currentKey = iterator.next();
			sql = sql.concat(", " + currentKey);
		}
		
		sql = sql.replaceFirst(", ", "(");
		sql = sql.concat(") ");
		
		return sql;
	}
	
	
	// create SQL VALUES
	private String createSQL_values(Map<String, String> values,
									Map<String, CashBookType> types) {
		String sql = "";
		
		Set<String> keys = values.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String currentKey = iterator.next();
			sql = sql.concat(", " + values.get(currentKey));
		}
		
		sql = sql.replaceFirst(", ", "VALUES(");
		sql = sql.concat(")");
		
		return sql;
	}	
	
	
// DELETE
	public boolean delete(GetableAttributeNamesDTO _dto) {
		
		return true;
	}
	
	

}
