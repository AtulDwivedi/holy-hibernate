package com.atuldwivedi.learn.hibernate.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static Session session;

	public static Session getSession() {

		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Trainer.class).buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		return session;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}
	
	public static void closeSession(){
		session.close();
	}
}
