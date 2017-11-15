package com.atuldwivedi.learn.hibernate.association.onetoone.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
	private static SessionFactory sessionFactory;

	private static Session session;

	public static void main(String[] args) {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Phone.class)
				.addAnnotatedClass(PhoneDetails.class).buildSessionFactory();

		try {
			savePhoneOrDetails();
			updatePhoneOrDetails();
			deletePhoneOrDetails();

			// getPhoneOrDetails();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	private static void savePhoneOrDetails() {
		System.out.println("\n>> savePhoneOrDetails()");
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone1 = new Phone("9110460027");
		PhoneDetails phone1Details = new PhoneDetails("JIO", "4G");

		phone1.addDetails(phone1Details);

		session.save(phone1);

		Phone phone2 = new Phone("9110460027");
		PhoneDetails phone2Details = new PhoneDetails("JIO", "4G");

		phone2.addDetails(phone2Details);
		// or
		// phone2Details.setPhone(phone2);

		session.save(phone2Details);

		session.getTransaction().commit();

		getPhoneOrDetails();
		System.out.println("<< savePhoneOrDetails()");
	}

	private static void updatePhoneOrDetails() {
		System.out.println("\n>> updatePhoneOrDetails()");
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		phone.setNumber("+91-9110460027");
		phone.getDetails().setTechnology("4G LTE");

		// session.save(phone);
		// or
		session.save(phone.getDetails());
		session.getTransaction().commit();

		getPhoneOrDetails();
		System.out.println("<< updatePhoneOrDetails()");
	}

	private static void deletePhoneOrDetails() {
		System.out.println("\n>> deletePhoneOrDetails()");
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		// session.delete(phone);

		// or
		session.delete(phone.getDetails());
		session.getTransaction().commit();

		getPhoneOrDetails();
		System.out.println("<< deletePhoneOrDetails()");
	}

	private static void getPhoneOrDetails() {
		System.out.println("  >> getPhoneOrDetails()");
		session = sessionFactory.openSession();
		session.beginTransaction();

		Phone phone = session.get(Phone.class, 1l);

		System.out.println((phone != null) ? "  " + phone : "  No phone found!");

		// or

		PhoneDetails phoneDetails = session.get(PhoneDetails.class, 1l);

		System.out.println((phoneDetails != null) ? "  " + phoneDetails + " " + phoneDetails.getPhone()
				: "  No phone detail found!");

		session.getTransaction().commit();
		System.out.println("  << getPhoneOrDetails()");
	}
}
