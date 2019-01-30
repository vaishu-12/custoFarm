package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Employee
{
	private String firstName;
	private String lastName;
	private String email;
	private long contact;
	private String address;
	private WareHouse warehouse;
	
	public Manager() {
		System.out.println("in manager def constr");
	}

	public Manager(String firstName, String lastName, String email, long contact, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public WareHouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WareHouse warehouse) {
		this.warehouse= warehouse;
	}

	@Override
	public String toString() {
		return "Manager [EmpId="+getEmpId()+"firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contact="
				+ contact + ", address=" + address + "username="+getUserName()+"password="+getPassword()+"]";
	}
	
	
	
}
