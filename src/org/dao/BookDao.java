package org.dao;

import org.vo.Book;

/**
 * 
 * @ClassName: BookDao
 * @Description: book接口类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public interface BookDao {
	/**
	 * 
	 * @Title: addBook
	 * @Description: 追加图书信息
	 * @param @param book 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void addBook(Book book);

	/**
	 * 
	 * @Title: deleteBook
	 * @Description: 删除图书信息
	 * @param @param ISBN 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteBook(String ISBN);

	/**
	 * 
	 * @Title: updateBook
	 * @Description: 修改图书信息
	 * @param @param book 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void updateBook(Book book);

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
}
