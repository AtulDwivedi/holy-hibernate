package com.atuldwivedi.learn.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			Student student = session.get(Student.class, 1001l);
			System.out.println(student);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
