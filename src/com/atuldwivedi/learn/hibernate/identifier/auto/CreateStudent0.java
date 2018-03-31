package com.atuldwivedi.learn.hibernate.identifier.auto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent0 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student0.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			/*
			 * there is no need to provide roll number, it'll be generated
			 * automatically as sequence number
			 */
			Student0 std01 = new Student0("Atul", "atul.wnw@gmail.com", "9110460027", "Bengaluru");
			Student0 std02 = new Student0("John Rodson", "john@springframework.org", "9876543210", "New York");
			Student0 std03 = new Student0("Martin Fowler", "martin@martinfowler.com", "9876543211", "LA");

			session.save(std01);
			session.save(std02);
			session.save(std03);

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}

	}
}
