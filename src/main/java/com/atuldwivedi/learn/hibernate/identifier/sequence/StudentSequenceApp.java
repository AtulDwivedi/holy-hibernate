package com.atuldwivedi.learn.hibernate.identifier.sequence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentSequenceApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentSequence.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			/*
			 * there is no need to provide roll number, it'll be generated
			 * automatically as sequence number
			 */
			StudentSequence std01 = new StudentSequence("Atul", "atul.wnw@gmail.com", "9110460027", "Bengaluru");
			StudentSequence std02 = new StudentSequence("John Rodson", "john@springframework.org", "9876543210", "New York");
			StudentSequence std03 = new StudentSequence("Martin Fowler", "martin@martinfowler.com", "9876543211", "LA");

			session.save(std01);
			session.save(std02);
			session.save(std03);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}
}
