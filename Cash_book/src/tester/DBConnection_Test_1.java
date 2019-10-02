package tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cash_book.model.dbConnection.DBConnection;

// DBConnection 이용한 DB접속 테스터
public class DBConnection_Test_1 {
	public static void main(String[] args) {
		Connection connection = DBConnection.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("sql");
			ResultSet resultSet = preparedStatement.getResultSet();
			
			System.out.println();
			
			DBConnection.close(statement);
			DBConnection.close(preparedStatement);
			DBConnection.close(resultSet);
			DBConnection.closeConnection();
			
		} catch(SQLException e) {
			System.out.println(e);
		}		
	}
}
