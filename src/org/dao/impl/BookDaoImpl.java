package org.dao.impl;

import org.dao.BaseDAO;
import org.dao.BookDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.vo.Book;

/**
 * 
 * @ClassName: BookDaoImpl
 * @Description: bookʵ����
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public class BookDaoImpl extends BaseDAO implements BookDao {// ʵ�֣�׷��ͼ����Ϣ

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			session.save(book);// �־û��������
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
	public void deleteBook(String ISBN) {// ʵ�֣�ɾ��ͼ����Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			Book book = this.selectBook(ISBN);// ��ISBN��ȡ��Ҫɾ��ͼ��
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			session.delete(book);// ɾ������
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
	public void updateBook(Book book) {// ʵ�֣��޸�ͼ����Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			session.update(book);// ִ���޸Ĳ���
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
	public Book selectBook(String ISBN) {// ʵ�֣���ѯͼ����Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Book book = null;
		try {
			session = getSession();// ��ȡ�Ự
			tx = session.beginTransaction();// ��������
			Query query = session.createQuery("from Book where ISBN = ?");
			query.setParameter(0, ISBN);// ����ISBN�Ų�ͼ����Ϣ
			query.setMaxResults(1);
			book = (Book) query.uniqueResult();// ���ز�ѯ�������
			tx.commit();// �ύ����
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// �ع�
			}
			e.printStackTrace();
		} finally {
			session.close();// �رջỰ
		}
		return book;// ���ز�ѯ���
	}

}
