package org.dao.impl;

import org.dao.BaseDAO;
import org.dao.StudentDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Student;

/**
 * 
 * @ClassName: StudentDaoImpl
 * @Description: student实现类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public class StudentDaoImpl extends BaseDAO implements StudentDao {

	@Override
	public Student selectStudent(String readerId) {// 实现：查询读者信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Student stu = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			stu = (Student) session.get(Student.class, readerId);// 根据借书证号获取读者信息
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return stu;// 返回查询结果
	}

}
