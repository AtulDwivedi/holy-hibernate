package com.atuldwivedi.learn.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			List<Student> studentsList1 = session.createQuery("from Student").getResultList();
			System.out.println("\nFetched all students");
			System.out.println(studentsList1);
			
			
			List<Student> studentsList2 = session.createQuery("from Student s where s.name = 'Atul'").getResultList();
			System.out.println("\nFetched students using where clause");
			System.out.println(studentsList2);
			
			
			List<Student> studentsList3 = session.createQuery("from Student s where s.name = 'Atul' AND s.address = 'Bangalore'").getResultList();
			System.out.println("\nFetched students using where clause and predicate AND");
			System.out.println(studentsList3);
			
			List<Student> studentsList4 = session.createQuery("from Student s where s.email LIKE '%@atuldwivedi.com'").getResultList();
			System.out.println("\nFetched students using LIKE");
			System.out.println(studentsList4);
			
			
			List<Student> studentsList5 = session.createQuery("from Student s ORDER BY s.name").getResultList();
			System.out.println("\nFetched all students and ordered them");
			System.out.println(studentsList5);
			

			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
