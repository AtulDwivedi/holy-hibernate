package com.atuldwivedi.learn.hibernate.association.onetoone.uni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "hfw_onetoone_uni.Phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number")
	private String number;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_id")
	private PhoneDetails details;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", details=" + details + "]";
	}
}
