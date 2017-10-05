package com.atuldwivedi.learn.hibernate.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HFW_ONETOMANY_COURSE")
public class Course {

	private long id;

	private String title;
}
