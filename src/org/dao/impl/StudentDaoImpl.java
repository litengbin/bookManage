package org.dao.impl;

import org.dao.BaseDAO;
import org.dao.StudentDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Student;

/**
 * 
 * @ClassName: StudentDaoImpl
 * @Description: studentʵ����
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public class StudentDaoImpl extends BaseDAO implements StudentDao {

	@Override
	public Student selectStudent(String readerId) {// ʵ�֣���ѯ������Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Student stu = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			stu = (Student) session.get(Student.class, readerId);// ���ݽ���֤�Ż�ȡ������Ϣ
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return stu;// ���ز�ѯ���
	}

}
