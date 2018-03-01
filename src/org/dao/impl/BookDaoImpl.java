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
 * @Description: book实现类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public class BookDaoImpl extends BaseDAO implements BookDao {// 实现：追加图书信息

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			session.save(book);// 持久化保存对象
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}

	}

	@Override
	public void deleteBook(String ISBN) {// 实现：删除图书信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			Book book = this.selectBook(ISBN);// 由ISBN号取得要删的图书
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			session.delete(book);// 删除操作
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
	}

	@Override
	public void updateBook(Book book) {// 实现：修改图书信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			session.update(book);// 执行修改操作
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
	}

	@Override
	public Book selectBook(String ISBN) {// 实现：查询图书信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Book book = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			Query query = session.createQuery("from Book where ISBN = ?");
			query.setParameter(0, ISBN);// 根据ISBN号查图书信息
			query.setMaxResults(1);
			book = (Book) query.uniqueResult();// 返回查询结果对象
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return book;// 返回查询结果
	}

}
