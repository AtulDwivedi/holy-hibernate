package com.atuldwivedi.learn.hibernate.association.onetoone.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "hfw_onetoone_bi.PhoneDetails")
public class PhoneDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="provider")
	private String provider;

	@Column(name="technology")
	private String technology;

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	private Phone phone;

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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "PhoneDetails [id=" + id + ", provider=" + provider + ", technology=" + technology + "]";
	}
}