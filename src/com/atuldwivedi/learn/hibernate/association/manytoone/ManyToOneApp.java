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
			
//			Person person = new Person("Atul");
//			session.save(person);

//			Phone phone1 = new Phone("127-456-7890");
//			phone1.setPerson(person);
//			Phone phone2 = new Phone("321-456-7890");
//			phone2.setPerson(person);
			Person person = session.get(Person.class, 2l);
			Phone phone = session.get(Phone.class, 3l);
			phone.setPerson(person);
			session.save(phone);
//			session.save(phone2);
			session.getTransaction().commit();

//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//			Phone phone = session.get(Phone.class, 2l);
//			System.out.println("\n"+phone);
//			phone.setPerson(null);
//			session.save(phone);
//			Person p = session.get(Person.class, 1l);
//			session.delete(phone);
//			session.getTransaction().commit();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
