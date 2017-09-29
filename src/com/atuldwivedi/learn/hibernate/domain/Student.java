package com.atuldwivedi.learn.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hfw_student")
public class Student {

	@Id
	@Column(name = "roll_number")
	private int rollNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNumber, String name, String email, String mobile, String address) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

}
