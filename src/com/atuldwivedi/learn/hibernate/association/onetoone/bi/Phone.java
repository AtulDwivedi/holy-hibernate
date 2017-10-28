package com.atuldwivedi.learn.hibernate.association.onetoone.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "hfw_onetoone_bi.Phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number")
	private String number;

	@OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

	public PhoneDetails getDetails() {
		return details;
	}

	public void addDetails(PhoneDetails details) {
		details.setPhone(this);
		this.details = details;
	}

	public void removeDetails() {
		if (details != null) {
			details.setPhone(null);
			this.details = null;
		}
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + ", details=" + details + "]";
	}
}
