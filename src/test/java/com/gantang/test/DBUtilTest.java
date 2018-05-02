package com.gantang.test;

import org.hibernate.Session;
import org.junit.Test;

import com.gantang.db.DBUtil;

public class DBUtilTest {

	@Test
	public void testGetSession() {
		Session session = DBUtil.getSession();
		System.out.println(session);
		DBUtil.colseSession(session);
		System.out.println(session);
	}
}
