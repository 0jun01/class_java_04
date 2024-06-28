package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		// Connection 객체를 얻어서 insert 구문을 직접 만들어 보세요
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			String query = "insert into employee values( ?, ? ,? , ? , now())";
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setInt(1, 8);
			pr.setString(2, "서치원");
			pr.setString(3, "컴공");
			pr.setString(4, "10000.00");

			int rowCount = pr.executeUpdate();
			System.out.println("rowCount : " + rowCount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end of main
} // end of class
