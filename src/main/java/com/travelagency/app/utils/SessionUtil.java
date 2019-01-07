package com.travelagency.app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SessionUtil {

	public static Session getSession() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("sf= " + sf);
//		Session session ;
		return HibernateUtil.getSessionFactory().openSession();
	}

	public static Session openTransactionSession() {
		Session session = getSession();
		session.beginTransaction();
		return session;		
	}

	public static void closeTransactionSession(Session session) {
		session.getTransaction().commit();
//		Transaction transaction = 
//		transaction.commit();
		session.close();
	}
}
