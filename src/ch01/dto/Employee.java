package ch01.dto;

import lombok.ToString;

// DTO 설계 하고
// 값을 담아서 . 연산자를 사용해 보시오

@ToString
public class Employee {

	public int id;
	public String name;
	public String department;
	public double salary;
	public String hire_date;

}
