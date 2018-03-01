package org.dao;

import java.util.List;

import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendDao
 * @Description: lend接口类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public interface LendDao {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: 分页查询指定借书证号的读者所借图书的信息
	 * @param @param readerId
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return 参数
	 * @return List<Lend> 返回类型
	 * @throws
	 */
	public List<Lend> selectBook(String readerId, int pageNow, int pageSize);

	/**
	 * 
	 * @Title: selectBookSize
	 * @Description: 查询指定借书证号的读者所借图书的总数
	 * @param @param readerId
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int selectBookSize(String readerId);

	/**
	 * 
	 * @Title: addLend
	 * @Description: 借书
	 * @param @param lend
	 * @param @param book
	 * @param @param student 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void addLend(Lend lend, Book book, Student student);

	/**
	 * 
	 * @Title: selectByBookISBN
	 * @Description: 根据图书ID查询Lend的信息
	 * @param @param ISBN
	 * @param @return 参数
	 * @return Lend 返回类型
	 * @throws
	 */
	public Lend selectByBookISBN(String ISBN);

	/**
	 * 
	 * @Title: selectByBookId
	 * @Description: 根据图书id查询Lend信息
	 * @param @param bookId
	 * @param @return 参数
	 * @return Lend 返回类型
	 * @throws
	 */
	public Lend selectByBookId(String bookId);
}
