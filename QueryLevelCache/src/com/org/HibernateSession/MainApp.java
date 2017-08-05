package com.org.HibernateSession;

import java.util.List;

import org.hibernate.Query;
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
		Query query1=session1.createQuery("from Student s where s.id=1");
		query1.setCacheable(true);
		List list=query1.list();
		
		session1.close();
		
		Session session2=sf.openSession();
		session2.beginTransaction();
		Query query2=session2.createQuery("from Student s where s.id=1");
		query2.setCacheable(true);
		list=query2.list();
		
		session2.close();

	}

}
