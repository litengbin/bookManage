package org.dao.impl;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.LendDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendDaoImpl
 * @Description: lendʵ����
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public class LendDaoImpl extends BaseDAO implements LendDao {

	@Override
	public List<Lend> selectBook(String readerId, int pageNow, int pageSize) {// ʵ�֣���ҳ��ѯָ������֤�ŵĶ�������ͼ�����Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Lend> list = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			Query query = session
					.createQuery("select l.bookId,l.ISBN,b.bookName,b.publisher,b.price,l.LTime from Lend as l,Book as b where l.readerId = ? and b.ISBN = l.ISBN");
			query.setParameter(0, readerId);
			// ��ҳ
			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = query.list();// ���ز�ѯ���
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return list;// ���ز�ѯ���
	}

	@Override
	public int selectBookSize(String readerId) {// ʵ�֣���ѯָ������֤�ŵĶ�������ͼ�������
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		int size = 0;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction(); // ��������
			Query query = session.createQuery("from Lend where readerId = ?");
			query.setParameter(0, readerId);// ������֤�Ų�ѯ
			size = query.list().size();// ���ؽ��
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return size;
	}

	@Override
	public void addLend(Lend lend, Book book, Student student) {// ����
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			session.save(lend);// ��ӽ�����Ϣ
			session.update(book);// �޸�ͼ����Ϣ�������-1
			session.update(student);// �޸�ѧ����Ϣ��������+1
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
	}

	@Override
	public Lend selectByBookISBN(String ISBN) {// ʵ�֣�����ͼ��ISBN��ѯLend��Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			Query query = session.createQuery("from Lend where ISBN = ?");// ����ͼ��ISBN�Ų�ѯ
			query.setParameter(0, ISBN);
			query.setMaxResults(1);
			lend = (Lend) query.uniqueResult();// ���ز�ѯ���
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return lend;// ���ز�ѯ���
	}

	@Override
	public Lend selectByBookId(String bookId) {// ʵ�֣�����ͼ��id��ѯlend��Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			lend = (Lend) session.get(Lend.class, bookId);// ����ͼ��id��ȡlend��Ϣ
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return lend;// ���ز�ѯ���
	}

}
