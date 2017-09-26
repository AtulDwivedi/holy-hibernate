package com.atuldwivedi.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atuldwivedi.learn.hibernate.domain.Student;

public class StudentCreate {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Student student = new Student();
		student.setStudentId(10003);
		student.setStudentName("Atul Dwivedi");
		try{
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
		}
		finally {
			sessionFactory.close();
		}
		
	}
}
