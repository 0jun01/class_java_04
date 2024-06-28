package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에세 절대 루트 계정 사용 금지
		String password = "asd123";

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			String query = "Delete from employee where name = ?";
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setString(1, "이순신");
			int rowCounts = pr.executeUpdate();
			System.out.println("rowCounts : " + rowCounts);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
