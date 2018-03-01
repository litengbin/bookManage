package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @ClassName: BaseDAO
 * @Description: ����
 * @author litengbin
 * @date 2017��6��9��
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
