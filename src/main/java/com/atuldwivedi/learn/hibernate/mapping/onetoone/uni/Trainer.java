package com.atuldwivedi.learn.hibernate.mapping.onetoone.uni;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HFW_ONETOONE_UNI.HFW_ONETOONE_TRAINER")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "trainer_detail_id")
	private TrainerDetail trainerDetail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Trainer(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public Trainer() {
		super();
	}

	public TrainerDetail getTrainerDetail() {
		return trainerDetail;
	}

	public void setTrainerDetail(TrainerDetail trainerDetail) {
		this.trainerDetail = trainerDetail;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", trainerDetail="
				+ trainerDetail + "]";
	}
}
