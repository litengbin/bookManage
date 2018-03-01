package org.dao.impl;

import org.dao.BaseDAO;
import org.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Login;

/**
 * 
 * @ClassName: LoginDaoImpl
 * @Description: loginʵ����
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public class LoginDaoImpl extends BaseDAO implements LoginDao {

	@Override
	public Login checkLogin(String name, String password) {// ʵ�֣���֤�û���Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Login login = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			Query query = session
					.createQuery("from Login where name = ? and password = ?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			query.setMaxResults(1);
			login = (Login) query.uniqueResult();// ִ�в�ѯ
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return login;
	}
}
