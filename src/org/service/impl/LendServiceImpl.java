package org.service.impl;

import java.util.List;

import org.dao.LendDao;
import org.service.LendService;
import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendServiceImpl
 * @Description: 业务逻辑接口LendService的实现类
 * @author litengbin
 * @date 2017年6月10日
 * 
 */
public class LendServiceImpl implements LendService {
	private LendDao lendDao;

	@Override
	public List selectBook(String readerId, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return lendDao.selectBook(readerId, pageNow, pageSize);
	}

	@Override
	public int selectBookSize(String readerId) {
		// TODO Auto-generated method stub
		return lendDao.selectBookSize(readerId);
	}

	@Override
	public void addLend(Lend lend, Book book, Student student) {
		// TODO Auto-generated method stub
		lendDao.addLend(lend, book, student);
	}

	@Override
	public Lend selectByBookId(String bookId) {
		// TODO Auto-generated method stub
		return lendDao.selectByBookId(bookId);
	}

	@Override
	public Lend selectByBookISBN(String ISBN) {
		// TODO Auto-generated method stub
		return lendDao.selectByBookISBN(ISBN);
	}

	public LendDao getLendDao() {
		return lendDao;
	}

	public void setLendDao(LendDao lendDao) {
		this.lendDao = lendDao;
	}

}
