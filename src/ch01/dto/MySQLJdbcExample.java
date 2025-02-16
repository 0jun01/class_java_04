package ch01.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch01.dto.Employee;

public class MySQLJdbcExample {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();

		// Employee employee = new Employee(id, name, department, salary, hire_date);
		// 준비물
		//
		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에세 절대 루트 계정 사용 금지
		String password = "asd123";

		// 필요 데이터 타입
		// JDBC API 레벨(자바 개발자들이 개념화 시켜 놓은 클래스들이다.)
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// 1. MySQL 구현체를 사용하겠다는 설정을 해야 한다.
		// JDBC 드라이버 로드(MySQL 드라이브 쓰겠다는 선언)

		try {
			// 1. 메모리에 사용하는 드라이버(JDBC API를 구현한 클래스) 클래스를 띄운다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 데이터 베이스 연결 설정
			connection = DriverManager.getConnection(url, user, password);

			// 3. SQL 실행
			statement = connection.createStatement();
			// 딱 2가지는 기억하자 쿼리를 싱행 시키는 메서드
			resultSet = statement.executeQuery("SELECT * FROM employee limit 2"); // select 실행시 사용한다.
			// statement.executeUpdate(password); --> Insert, Update, delete 사용

			// 구문 분석 -- 파싱
			// 4. 결과 처리
			Employee employee = null;

			List<Employee> list = new ArrayList<>();
			while (resultSet.next()) {
				// Employee employee = new Employee(id, name, department, salary, hire_date);
				employee = new Employee();
				employee.id = resultSet.getInt("id");
				employee.name = resultSet.getString("name");
				employee.department = resultSet.getString("department");
				employee.salary = resultSet.getDouble("salary");
				employee.hire_date = resultSet.getString("hire_date");
				list.add(employee);
			}

			for (Employee employee2 : list) {
				System.out.println(employee2.toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
