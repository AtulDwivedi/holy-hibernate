package com.atuldwivedi.learn.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atuldwivedi.learn.hibernate.domain.Student;

public class CreateStudent {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		Student student = new Student("Atul Dwivedi", "contact@atuldwivedi.com", "9110460027", "Bengaluru");

		try {
			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}
}
