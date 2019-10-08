package com.cash_book.model.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnection {
	private static OracleDataSource dataSource;
	private static Connection connection;
	
	private final static String URL;
	private final static String USER;
	private final static String PW;
	
	static {
		URL = "jdbc:oracle:thin:@localhost:1521:XE";
		USER = "CASH_BOOK";
		PW = "tiger";
		
		initConnector();
	}
	
	
// 생성자
	private DBConnection() { }
	
	
// Connection 초기화
	private static void initConnector() {
		try {
			dataSource = new OracleDataSource();
			dataSource.setURL(URL);
			dataSource.setUser(USER);
			dataSource.setPassword(PW);
			
			connection = dataSource.getConnection();
			
//			System.out.println("** " + USER + " 계정 접속 완료 **");
			
		} catch(SQLException e) {
			System.out.println("접속에러 : " + e.getMessage());
		}
	}
	
	
	
// Connection getter
	public static Connection getConnection() {
		return connection;
	}
	
	
// Connection 해제
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
//				System.out.println("Connection 해제 완료");
				
			} catch(SQLException e) {
				System.out.println("Connection 해제 에러 : " + e.getMessage());
			}
		}
	}
	
// Statement 해제
	public static void close(Statement statement) {
		if(statement != null) {
			try {
				statement.close();
//				System.out.println("Statement 해제 완료");
				
			} catch(SQLException e) {
				System.out.println("Statement 해제 에러 : " + e.getMessage());
			}
		}
	}
	
// PreparedStatement 해제
	public static void close(PreparedStatement preparedStatement) {
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
//				System.out.println("PreparedStatement 해제 완료");
				
			} catch(SQLException e) {
				System.out.println("PreparedStatement 해제 에러 : " + e.getMessage());
			}
		}
	}
	
// ResultSet 해제
	public static void close(ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
//				System.out.println("ResultSet 해제 완료");
				
			} catch(SQLException e) {
				System.out.println("ResultSet 해제 에러 : " + e.getMessage());
			}
		}
	}
}
