package com.atuldwivedi.learn.hibernate.association.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "HFW_MANYTOONE.person.sql")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "person.sql [id=" + id + ", name=" + name + "]";
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}