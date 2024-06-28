package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에세 절대 루트 계정 사용 금지
		String password = "asd123";

		Connection connection = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			String query = "select * from employee limit 2";
			PreparedStatement pr = connection.prepareStatement(query);
			resultSet = pr.executeQuery();
			
			
			
			while (resultSet.next()) {
				System.out.println("id : " + resultSet.getInt("id"));
				System.out.println("name : " + resultSet.getString("name"));
				System.out.println("department : " + resultSet.getString("department"));
				System.out.println("salary : " + resultSet.getDouble("salary"));
				System.out.println("hire_date : " + resultSet.getString("hire_date"));
				System.out.println("---------------------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
