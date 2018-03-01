package org.service.impl;

import org.dao.BookDao;
import org.service.BookService;
import org.vo.Book;

/**
 * 
 * @ClassName: BookServiceImpl
 * @Description: 业务逻辑接口BookService的实现类
 * @author litengbin
 * @date 2017年6月10日
 * 
 */
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Override
	public Book selectBook(String ISBN) {
		// TODO Auto-generated method stub
		return bookDao.selectBook(ISBN);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(String ISBN) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(ISBN);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.updateBook(book);
	}

}
