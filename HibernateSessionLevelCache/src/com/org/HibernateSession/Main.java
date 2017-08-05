package com.org.HibernateSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();

		session.beginTransaction();

		//student object within a single session
		Student student1=(Student)session.get(Student.class, 1);
       /*since we are fetching the student object only within a single session therefore 
		select statement will run only once
		*/
		Student student2=(Student)session.get(Student.class, 1);

		session.getTransaction().commit();
		session.close();
	}

}
