package com.atuldwivedi.learn.hibernate.association.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneApp {

	private static SessionFactory sessionFactory;

	private static Session session;

	public static void main(String[] args) {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
					.addAnnotatedClass(Phone.class).buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			Person person = new Person();
			session.save(person);

			Phone phone1 = new Phone("123-456-7890");
			phone1.setPerson(person);
			Phone phone2 = new Phone("321-456-7890");
			phone2.setPerson(person);
			session.save(phone1);
			session.save(phone2);
			session.getTransaction().commit();

			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Phone phone = session.get(Phone.class, 2l);
			System.out.println("\n"+phone);
			phone.setPerson(null);
			session.save(phone);
			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
