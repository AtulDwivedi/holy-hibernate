package com.atuldwivedi.learn.hibernate.mapping.onetoone.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HFW_ONETOONE_BI.HFW_ONETOONE_TRAINER_DETAIL")
public class TrainerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "email")
	private String email;

	@Column(name = "website")
	private String website;
	
	@OneToOne(mappedBy="trainerDetail", cascade=CascadeType.ALL)
	private Trainer trainer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public TrainerDetail(String email, String website) {
		super();
		this.email = email;
		this.website = website;
	}

	public TrainerDetail() {
		super();
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "TrainerDetail [id=" + id + ", email=" + email + ", website=" + website + "]";
	}
}
