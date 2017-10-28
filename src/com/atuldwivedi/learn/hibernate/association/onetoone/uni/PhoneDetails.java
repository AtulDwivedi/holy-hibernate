package com.atuldwivedi.learn.hibernate.association.onetoone.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "hfw_onetoone_uni.PhoneDetails")
public class PhoneDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="provider")
	private String provider;

	@Column(name="technology")
	private String technology;

	public PhoneDetails() {
	}

	public PhoneDetails(String provider, String technology) {
		this.provider = provider;
		this.technology = technology;
	}

	public String getProvider() {
		return provider;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "PhoneDetails [id=" + id + ", provider=" + provider + ", technology=" + technology + "]";
	}
}