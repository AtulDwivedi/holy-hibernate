package com.atuldwivedi.learn.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atuldwivedi.learn.hibernate.id.Student01;
import com.atuldwivedi.learn.hibernate.id.Student02;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			// updating one record
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student std = session.get(Student.class, 1001l);
			std.setName("Atul Mukesh Dwivedi");
			session.getTransaction().commit();
			session.close();

			// updating all records
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			session2.createQuery("update Student set email = 'contact@gmail.com'").executeUpdate();
			session2.getTransaction().commit();
			session2.close();

			// updating selected records
			Session session3 = sessionFactory.getCurrentSession();
			session3.beginTransaction();
			session3.createQuery("update Student set email = 'contact2@gmail.com' where name = 'Atul Mukesh Dwivedi'")
					.executeUpdate();
			session3.getTransaction().commit();
			session3.close();

		} finally {
			sessionFactory.close();
		}
	}

}
