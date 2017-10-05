package com.atuldwivedi.learn.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atuldwivedi.learn.hibernate.id.Student01;
import com.atuldwivedi.learn.hibernate.id.Student02;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		try {
			// deleting one record
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// fetch the student object
			Student std = session.get(Student.class, 1001l);
			// delete the student object
			session.delete(std);
			session.getTransaction().commit();
			session.close();

			/*
			 * <h3>WARNNING</h3> 
			 * <p>never try this in production until you are double sure</p> 
			 * <p>deleting all records</p>
			 */
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			session2.createQuery("delete from Student").executeUpdate();
			session2.getTransaction().commit();
			session2.close();

			// deleting selected records
			Session session3 = sessionFactory.getCurrentSession();
			session3.beginTransaction();
			session3.createQuery("delete from Student where name = 'Atul'").executeUpdate();
			session3.getTransaction().commit();
			session3.close();

		} finally {
			sessionFactory.close();
		}
	}

}
