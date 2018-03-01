package org.service;

import java.util.List;

import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendService
 * @Description: 业务逻辑接口LendService
 * @author litengbin
 * @date 2017年6月10日
 * 
 */
public interface LendService {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: 查询图书
	 * @param @param readerId
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
	public List selectBook(String readerId, int pageNow, int pageSize);

	/**
	 * 
	 * @Title: selectBookSize
	 * @Description: 返回图书数
	 * @param @param readerId
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int selectBookSize(String readerId);

	/**
	 * 
	 * @Title: addLend
	 * @Description: 添加借书记录
	 * @param @param lend
	 * @param @param book
	 * @param @param student 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void addLend(Lend lend, Book book, Student student);

	/**
	 * 
	 * @Title: selectByBookId
	 * @Description: 查询借阅信息
	 * @param @param bookId
	 * @param @return 参数
	 * @return Lend 返回类型
	 * @throws
	 */
	public Lend selectByBookId(String bookId);

	/**
	 * 
	 * @Title: selectByBookISBN
	 * @Description: 查询借阅信息
	 * @param @param ISBN
	 * @param @return 参数
	 * @return Lend 返回类型
	 * @throws
	 */
	public Lend selectByBookISBN(String ISBN);
}
