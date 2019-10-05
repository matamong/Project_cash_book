package com.cash_book.model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.cash_book.model.AbstractDAO;
import com.cash_book.model.GetableAttributeNamesDTO;

public class MemberDAO extends AbstractDAO {
	
	
// 생성자
	public MemberDAO(Connection connection, GetableAttributeNamesDTO dto) {
		super(connection, dto);
	}
	
	
// SELECT
	@Override
	public GetableAttributeNamesDTO select(String sql) {
		String combinedSQL = "SELECT * FROM " + 
							 super.getDTO().getTableName() + " " +
							 sql;
		
		try {
			PreparedStatement preparedStatement = 
							super.getConnection().prepareStatement(combinedSQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
		} catch(SQLException e) {
			System.out.println("MemberDAO Err] " + e.getMessage());
		}
		
		return super.getDTO();
	}
	
// SELECT ( Map<String, String> )
	public Map<String, String> selectReturnMap(String sql) {
		Map<String, String> result = new HashMap<String, String>();
		
		
		return result;
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
