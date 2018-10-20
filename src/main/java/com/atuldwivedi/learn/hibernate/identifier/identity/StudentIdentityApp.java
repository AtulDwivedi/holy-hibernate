package com.atuldwivedi.learn.hibernate.identifier.identity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentIdentityApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentIdentity.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			/*
			 * there is no need to provide roll number, it'll be generated
			 * automatically as sequence number
			 */
			StudentIdentity std01 = new StudentIdentity("Atul", "atul.wnw@gmail.com", "9110460027", "Bengaluru");
			StudentIdentity std02 = new StudentIdentity("John Rodson", "john@springframework.org", "9876543210", "New York");
			StudentIdentity std03 = new StudentIdentity("Martin Fowler", "martin@martinfowler.com", "9876543211", "LA");

			session.save(std01);
			session.save(std02);
			session.save(std03);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}
}
