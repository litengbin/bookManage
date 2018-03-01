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
 * @Description: ����action��
 * @author litengbin
 * @date 2017��5��12��
 * 
 */
public class LendAction extends ActionSupport {
	private int pageNow = 1;// ��ʼҳ��Ϊ��1ҳ
	private int pageSize = 4;// ÿҳ��ʾ4����¼
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
	 * @Description: pageNow��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageNow() {
		return pageNow;
	}

	/**
	 * 
	 * @Title: setPageNow
	 * @Description: pageNow��setter����
	 * @param @param pageNow ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: pageSize��setter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: pageSize��setter����
	 * @param @param pageSize ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @Title: getLend
	 * @Description: lend��getter����
	 * @param @return ����
	 * @return Lend ��������
	 * @throws
	 */
	public Lend getLend() {
		return lend;
	}

	/**
	 * 
	 * @Title: setLend
	 * @Description: lend��setter����
	 * @param @param lend ����
	 * @return void ��������
	 * @throws
	 */
	public void setLend(Lend lend) {
		this.lend = lend;
	}

	/**
	 * 
	 * @Title: getMessage
	 * @Description: message��getter����
	 * @param @return ����
	 * @return String ��������
	 * @throws
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @Title: setMessage
	 * @Description: message��setter����
	 * @param @param message ����
	 * @return void ��������
	 * @throws
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @Title: selectAllLend
	 * @Description: ��ʾ���н����¼
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String selectAllLend() throws Exception {
		// �ж�����Ľ���֤���Ƿ�Ϊ��
		if (lend.getReaderId() == null || lend.getReaderId().equals("")) {
			this.setMessage("���������֤��");
			return SUCCESS;
		} else if (studentservice.selectStudent(lend.getReaderId()) == null) {
			// ����StudentDao�еĲ�ѯѧ���ķ��������Ϊnull�ͱ�ʾ����Ľ���֤�Ų�����
			this.setMessage("�����ڸ�ѧ��");
			return SUCCESS;
		}
		// ����LendDao�Ĳ�ѯ�ѽ�ͼ�鷽������ѯ�������õ��˷�ҳ��ѯ
		List list = lendservice.selectBook(lend.getReaderId(),
				this.getPageNow(), this.getPageSize());
		// ���ݵ�ǰҳ��һ����������¼������ҳ����Pager����
		Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
				.getReaderId()));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);// �����ѯ�ļ�¼
		request.put("page", page);// �����ҳ��¼
		request.put("readerId", lend.getReaderId());// �������֤��
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: lendBook
	 * @Description: ʵ�ֽ��鹦��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String lendBook() throws Exception {
		// BookDao bookDao = new BookDaoImpl();
		// ���ISBNΪ�ջ��߲����ڸ�ISBN���飬�ͷ��ص�ԭ���������ֻ�Ƕ�����ʾ��Ϣ
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
			this.setMessage("ISBN����Ϊ�ջ��߲����ڸ�ISBN��ͼ����߸�ISBN��ͼ��û�п������");
			return SUCCESS;
		} else if (lend.getBookId() == null || lend.getBookId().equals("")
				|| lendservice.selectByBookId(lend.getBookId()) != null) {
			lendservice.selectBook(lend.getReaderId(), this.getPageNow(),
					this.getPageSize());
			// ��������ͼ��idΪ�ջ��ͼ��id�Ѿ�����Ҳ���ص�ԭ�����������������ʾ��Ϣ
			List list = lendservice.selectBook(lend.getReaderId(),
					this.getPageNow(), this.getPageSize());
			Pager page = new Pager(pageNow, lendservice.selectBookSize(lend
					.getReaderId()));
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);// ԭ��������ѽ�ͼ��
			request.put("page", page);// ��ҳ
			request.put("readerId", lend.getReaderId());// ����֤��
			this.setMessage("��ͼ��ID�Ѿ����ڻ�ͼ��IDΪ�գ�");
			return SUCCESS;
		}
		Lend l = new Lend();
		l.setBookId(lend.getBookId());// ����ͼ��ID
		l.setISBN(lend.getISBN());// ����ͼ��ISBN
		l.setReaderId(lend.getReaderId());// ���ý���֤��
		l.setLTime(new Date());// ���ý���ʱ��Ϊ��ǰʱ��
		Book book = bookservice.selectBook(lend.getISBN());// ȡ�ø�ISBN��ͼ�����
		book.setSnum(book.getSnum() - 1);// ���ÿ����-1
		bookservice.updateBook(book);// �޸�ͼ��

		// StudentDao studentDao = new StudentDaoImpl();

		Student stu = studentservice.selectStudent(lend.getReaderId());
		stu.setNum(stu.getNum() + 1);// ����ѧ���Ľ�����+1
		lendservice.addLend(l, book, stu);// ����Dao�з���������Ϣ
		this.setMessage("����ɹ���");
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
