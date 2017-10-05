package com.atuldwivedi.learn.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// create student object
			Student student = new Student(1001l, "Atul", "atul.wnw@gmail.com", "9110460027", "Bengaluru");

			// save the student object
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}
}
