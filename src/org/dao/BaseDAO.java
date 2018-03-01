package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @ClassName: BaseDAO
 * @Description: 基类
 * @author litengbin
 * @date 2017年6月9日
 * 
 */
public class BaseDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
}
