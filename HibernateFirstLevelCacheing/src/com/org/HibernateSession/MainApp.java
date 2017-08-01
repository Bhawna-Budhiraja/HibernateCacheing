package com.org.HibernateSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();

		session.beginTransaction();

		/*since this is happening within one session so this is called first level caching.
		 * now hibernate will first take the object out and if there is no update so will execute the 
		 * Select statement only once.
		 * 
		 * Else if there seems to be an update then hibernate will execute the update
		 */

		//selecting the object student
		Student student1=(Student)session.get(Student.class, 1);
		student1.setName("updating value");
		session.getTransaction().commit();
		Student student2=(Student)session.get(Student.class, 1);

		session.close();
        sf.close();
		
	}

}
