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
 * @Description: login实现类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public class LoginDaoImpl extends BaseDAO implements LoginDao {

	@Override
	public Login checkLogin(String name, String password) {// 实现：验证用户信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Login login = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			Query query = session
					.createQuery("from Login where name = ? and password = ?");
			query.setParameter(0, name);
			query.setParameter(1, password);
			query.setMaxResults(1);
			login = (Login) query.uniqueResult();// 执行查询
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return login;
	}
}
