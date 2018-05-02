package com.gantang.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil {

	public static Session getSession() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	public static void colseSession(Session session) {
		if (session != null) {
			session.close();
			session.getSessionFactory().close();
		}
	}
}
