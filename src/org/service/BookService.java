package org.service;

import org.vo.Book;

/**
 * 
 * @ClassName: BookService
 * @Description: 业务逻辑接口BookService
 * @author litengbin
 * @date 2017年6月10日
 * 
 */
public interface BookService {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: 查询图书信息
	 * @param @param ISBN
	 * @param @return 参数
	 * @return Book 返回类型
	 * @throws
	 */
	public Book selectBook(String ISBN);

	/**
	 * 
	 * @Title: addBook
	 * @Description: 添加图书
	 * @param @param book 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void addBook(Book book);

	/**
	 * 
	 * @Title: deleteBook
	 * @Description: 删除图书
	 * @param @param ISBN 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteBook(String ISBN);

	/**
	 * 
	 * @Title: updateBook
	 * @Description: 修改图书
	 * @param @param book 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void updateBook(Book book);
}
