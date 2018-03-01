package org.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.service.BookService;
import org.service.LendService;
import org.service.StudentService;
import org.tool.Pager;
import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: LendAction
 * @Description: 借书action类
 * @author litengbin
 * @date 2017年5月12日
 * 
 */
public class LendAction extends ActionSupport {
	private int pageNow = 1;// 初始页面为第1页
	private int pageSize = 4;// 每页显示4条纪录
	private Lend lend;
	private String message;
	// LendDao lendDao = new LendDaoImpl();
	private LendService lendservice;
	private StudentService studentservice;
	private BookService bookservice;

	public LendService getLendservice() {
		return lendservice;
	}

	public void setLendservice(LendService lendservice) {
		this.lendservice = lendservice;
	}

	public StudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	public BookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	/**
	 * 
	 * @Title: getPageNow
	 * @Description: pageNow的getter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getPageNow() {
		return pageNow;
	}

	/**
	 * 
	 * @Title: setPageNow
	 * @Description: pageNow的setter方法
	 * @param @param pageNow 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: pageSize的setter方法
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: pageSize的setter方法
	 * @param @param pageSize 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @Title: getLend
	 * @Description: lend的getter方法
	 * @param @return 参数
	 * @return Lend 返回类型
	 * @throws
	 */
	public Lend getLend() {
		return lend;
	}

	/**
	 * 
	 * @Title: setLend
	 * @Description: lend的setter方法
	 * @param @param lend 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setLend(Lend lend) {
		this.lend = lend;
	}

	/**
	 * 
	 * @Title: getMessage
	 * @Description: message的getter方法
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @Title: setMessage
	 * @Description: message的setter方法
	 * @param @param message 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @Title: selectAllLend
	 * @Description: 显示所有借书记录
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String selectAllLend() throws Exception {
		// 判断输入的借书证号是否为空
		if (lend.getReaderId() == null || lend.getReaderId().equals("")) {
			this.setMessage("请输入借书证号");
			return SUCCESS;
		} else if (studentservice.selectStudent(lend.getReaderId()) == null) {
			// 调用StudentDao中的查询学生的方法，如果为null就表示输入的借书证号不存在
			this.setMessage("不存在该学生");
			return SUCCESS;
		}
		// 调用LendDao的查询已借图书方法，查询，这里用到了分页查询
		List list = lendservice.selectBook(lend.getReaderId(),
				this.getPageNow(), this.getPageSize());
		// 根据当前页及一共多少条记录创建分页的类Pager对象
		Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
				.getReaderId()));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);// 保存查询的记录
		request.put("page", page);// 保存分页记录
		request.put("readerId", lend.getReaderId());// 保存借书证号
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: lendBook
	 * @Description: 实现借书功能
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String lendBook() throws Exception {
		// BookDao bookDao = new BookDaoImpl();
		// 如果ISBN为空或者不存在该ISBN的书，就返回到原来的情况，只是多了提示信息
		if (lend.getISBN() == null || lend.getISBN().equals("")
				|| bookservice.selectBook(lend.getISBN()) == null
				|| (bookservice.selectBook(lend.getISBN()).getSnum()) < 1) {
			List list = lendservice.selectBook(lend.getReaderId(),
					this.pageNow, this.getPageSize());
			Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
					.getReaderId()));
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			this.setMessage("ISBN不能为空或者不存在该ISBN的图书或者该ISBN的图书没有库存量！");
			return SUCCESS;
		} else if (lend.getBookId() == null || lend.getBookId().equals("")
				|| lendservice.selectByBookId(lend.getBookId()) != null) {
			lendservice.selectBook(lend.getReaderId(), this.getPageNow(),
					this.getPageSize());
			// 如果输入的图书id为空或该图书id已经存在也返回到原来的情况，并给出提示信息
			List list = lendservice.selectBook(lend.getReaderId(),
					this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
					.getReaderId()));
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);// 原来查出的已借图书
			request.put("page", page);// 分页
			request.put("readerId", lend.getReaderId());// 借书证号
			this.setMessage("该图书ID已经存在或图书ID为空！");
			return SUCCESS;
		}
		Lend l = new Lend();
		l.setBookId(lend.getBookId());// 设置图书ID
		l.setISBN(lend.getISBN());// 设置图书ISBN
		l.setReaderId(lend.getReaderId());// 设置借书证号
		l.setLTime(new Date());// 设置借书时间为当前时间
		Book book = bookservice.selectBook(lend.getISBN());// 取得该ISBN的图书对象
		book.setSnum(book.getSnum() - 1);// 设置库存量-1
		bookservice.updateBook(book);// 修改图书

		// StudentDao studentDao = new StudentDaoImpl();

		Student stu = studentservice.selectStudent(lend.getReaderId());
		stu.setNum(stu.getNum() + 1);// 设置学生的借书量+1
		lendservice.addLend(l, book, stu);// 调用Dao中方法插入信息
		this.setMessage("借书成功！");
		// studentDao.updateStudent(stu);
		List list = lendservice.selectBook(lend.getReaderId(),
				this.getPageNow(), this.getPageSize());
		Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
				.getReaderId()));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return SUCCESS;
	}
}
