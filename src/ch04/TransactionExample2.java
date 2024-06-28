package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/m_board?serverTimezone=Asia/Seoul";
		String id = "root";
		String password = "asd123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, id, password)) {
				conn.setAutoCommit(true);
				String sqlInsert = " INSERT INTO board(userId,title,content,readCount)" + " values(?, ? , ?, ?);";

				PreparedStatement psmt1 = conn.prepareStatement(sqlInsert);
				psmt1.setInt(1, 6);
				psmt1.setString(2, "감자가 먹고싶어요");
				psmt1.setString(3, "감자가 먹고싶은 김철수입니다. 감자좀 사주세요");
				psmt1.setInt(4, 9000);
				psmt1.executeUpdate();

				String sqlInsert2 = " INSERT INTO reply(userid,boardId,content,createDate)"
						+ " VALUES( ? , ? , ? , now());";
				PreparedStatement psmt2 = conn.prepareStatement(sqlInsert2);
				psmt2.setInt(1, 6);
				psmt2.setInt(2, 4);
				psmt2.setString(3, "제가 사드릴게요");
				psmt2.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
