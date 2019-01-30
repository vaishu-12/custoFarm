package com.app.pojos;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee 
{
	private Integer empId;
	private String 	userName;
	private String password;
	private String role;
	
	public Employee() {
		System.out.println("in Employee def constructor");
	}

	public Employee(Integer empId, String userName, String password, String role) {
		super();
		this.empId = empId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public Employee(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(unique=true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}
