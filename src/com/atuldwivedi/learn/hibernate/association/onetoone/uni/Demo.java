package com.atuldwivedi.learn.hibernate.association.onetoone.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atuldwivedi.learn.hibernate.mapping.onetoone.uni.Trainer;
import com.atuldwivedi.learn.hibernate.mapping.onetoone.uni.TrainerDetail;

public class Demo {
	private static SessionFactory sessionFactory;

	private static Session session;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Phone.class)
				.addAnnotatedClass(PhoneDetails.class).buildSessionFactory();

		try {
			savePhone();
			getPhone();
			
			updatePhoneAndDetails();
			getPhone();
			
			deletePhone();
			getPhone();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void savePhone() {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = new Phone("9110460027");
		PhoneDetails phoneDetails = new PhoneDetails("JIO", "4G");

		phone.setDetails(phoneDetails);

		session.save(phone);

		session.getTransaction().commit();
	}

	private static void getPhone() {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		System.out.println("----");
		System.out.println(phone);
		System.out.println("----");

		session.getTransaction().commit();
	}

	private static void updatePhoneAndDetails() {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		phone.setNumber("+91-9110460027");
		phone.getDetails().setTechnology("4G LTE");

		session.save(phone);
		session.getTransaction().commit();
	}

	private static void deletePhone() {
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		session.delete(phone);

		session.getTransaction().commit();
	}
}
