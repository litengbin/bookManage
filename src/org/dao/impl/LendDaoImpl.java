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
 * @Description: lend实现类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public class LendDaoImpl extends BaseDAO implements LendDao {

	@Override
	public List<Lend> selectBook(String readerId, int pageNow, int pageSize) {// 实现：分页查询指定借书证号的读者所借图书的信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Lend> list = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			Query query = session
					.createQuery("select l.bookId,l.ISBN,b.bookName,b.publisher,b.price,l.LTime from Lend as l,Book as b where l.readerId = ? and b.ISBN = l.ISBN");
			query.setParameter(0, readerId);
			// 分页
			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = query.list();// 返回查询结果
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return list;// 返回查询结果
	}

	@Override
	public int selectBookSize(String readerId) {// 实现：查询指定借书证号的读者所借图书的总数
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		int size = 0;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction(); // 创建事务
			Query query = session.createQuery("from Lend where readerId = ?");
			query.setParameter(0, readerId);// 按借书证号查询
			size = query.list().size();// 返回结果
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return size;
	}

	@Override
	public void addLend(Lend lend, Book book, Student student) {// 借书
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			session.save(lend);// 添加借书信息
			session.update(book);// 修改图书信息，库存量-1
			session.update(student);// 修改学生信息，借书量+1
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
	public Lend selectByBookISBN(String ISBN) {// 实现：根据图书ISBN查询Lend信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			Query query = session.createQuery("from Lend where ISBN = ?");// 根据图书ISBN号查询
			query.setParameter(0, ISBN);
			query.setMaxResults(1);
			lend = (Lend) query.uniqueResult();// 返回查询结果
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return lend;// 返回查询结果
	}

	@Override
	public Lend selectByBookId(String bookId) {// 实现：根据图书id查询lend信息
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Lend lend = null;
		try {
			session = getSession();// 获取会话
			tx = session.beginTransaction();// 创建事务
			lend = (Lend) session.get(Lend.class, bookId);// 根据图书id获取lend信息
			tx.commit();// 提交事务
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();// 回滚
			}
			e.printStackTrace();
		} finally {
			session.close();// 关闭会话
		}
		return lend;// 返回查询结果
	}

}
