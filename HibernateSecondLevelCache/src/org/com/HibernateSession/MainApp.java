package org.com.HibernateSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		//first session
		Session session1=sf.openSession();
		session1.beginTransaction();
		Student student=(Student)session1.get(Student.class, 1);
		session1.getTransaction().commit();
		
		//second session when second level cache is enabled.Thus only once the select statement will get 
		//executed
		
		Session session2=sf.openSession();
		session2.beginTransaction();
		Student student2=(Student)session2.get(Student.class, 1);
		session2.getTransaction().commit();
		
		
		
	}

}
