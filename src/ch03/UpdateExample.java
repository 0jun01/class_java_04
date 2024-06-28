package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에세 절대 루트 계정 사용 금지
		String password = "asd123";

		// Connection 객체를 얻어서 수정 구문을 직접 만들어 보세요
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			String query = "Update employee set name = ? where id = ?";
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setString(1, "강감찬");
			pr.setInt(2, 6);
			int rowCount = pr.executeUpdate();
			System.out.println("rowCount : " + rowCount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
