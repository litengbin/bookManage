package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.dao.BookDao;
import org.service.BookService;
import org.service.LendService;
import org.vo.Book;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: BookAction
 * @Description: 图书action类
 * @author litengbin
 * @date 2017年5月12日
 * 
 */
public class BookAction extends ActionSupport {

	private String message;
	private File photo;
	private Book book;
	private BookService bookservice;
	private LendService lendservice;

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
	 * @Title: getPhoto
	 * @Description: photo的getter方法
	 * @param @return 参数
	 * @return File 返回类型
	 * @throws
	 */
	public File getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @Title: setPhoto
	 * @Description: photo的setter方法
	 * @param @param photo 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	/**
	 * 
	 * @Title: getBook
	 * @Description: book的getter方法
	 * @param @return 参数
	 * @return Book 返回类型
	 * @throws
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * 
	 * @Title: setBook
	 * @Description: book的setter方法
	 * @param @param book 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	// BookDao bookDao = new BookDaoImpl();

	/**
	 * 
	 * @Title: addBook
	 * @Description: 添加图书信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String addBook() throws Exception {
		if (book.getISBN() == null || "".equals(book.getISBN())) {
			this.setMessage("ISBN为空!添加失败!");
			return SUCCESS;
		}
		Book bo = bookservice.selectBook(book.getISBN());
		if (bo != null) {// 判断要添加的图书是否已经存在
			this.setMessage("ISBN已经存在！");
			return SUCCESS;
		}
		Book b = new Book();
		b.setISBN(book.getISBN());
		b.setBookName(book.getBookName());
		b.setAuthor(book.getAuthor());
		b.setPublisher(book.getPublisher());
		b.setPrice(book.getPrice());
		b.setCnum(book.getCnum());
		b.setSnum(book.getCnum());
		b.setSummary(book.getSummary());
		if (this.getPhoto() != null) {
			FileInputStream fis = new FileInputStream(this.getPhoto());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			b.setPhoto(buffer);
			fis.close();
		}
		bookservice.addBook(b);
		this.setMessage("添加成功！");
		return SUCCESS;
	}

	public BookService getBookservice() {
		return bookservice;
	}

	public void setBookservice(BookService bookservice) {
		this.bookservice = bookservice;
	}

	public LendService getLendservice() {
		return lendservice;
	}

	public void setLendservice(LendService lendservice) {
		this.lendservice = lendservice;
	}

	/**
	 * 
	 * @Title: deleteBook
	 * @Description: 删除图书信息
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String deleteBook() throws Exception {
		if (book.getISBN() == null || book.getISBN().equals("")) {
			this.setMessage("请输入ISBN号");
			return SUCCESS;
		}
		Book bo = bookservice.selectBook(book.getISBN());
		if (bo == null) {// 首先判断是否存在该图书
			this.setMessage("要删除的图书不存在");
			return SUCCESS;
		} else if (lendservice.selectByBookISBN(book.getISBN()) != null) {
			this.setMessage("该图书已经被借出，故不能删除图书信息！");
			return SUCCESS;
		}
		bookservice.deleteBook(book.getISBN());
		this.setMessage("删除成功！");
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: selectBook
	 * @Description: 图书查询
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String selectBook() throws Exception {
		Book onebook = bookservice.selectBook(book.getISBN());
		if (onebook == null) {
			this.setMessage("不存在该图书！");
			return SUCCESS;
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("onebook", onebook);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getImage
	 * @Description:获得图书的image
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String getImage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		String ISBN = book.getISBN();
		Book b = bookservice.selectBook(ISBN);
		byte[] photo = b.getPhoto();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if (photo != null && photo.length != 0) {
			for (int i = 0; i < photo.length; i++) {
				os.write(photo[i]);
			}
			os.flush();
		}
		return NONE;
	}

	/**
	 * 
	 * @Title: updateBook
	 * @Description: 修改图书
	 * @param @return
	 * @param @throws Exception 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String updateBook() throws Exception {
		Book b = bookservice.selectBook(book.getISBN());
		if (b == null) {
			this.setMessage("要修改的图书不存在，请先查看是否存在该图书！");
			return SUCCESS;
		}
		b.setISBN(book.getISBN());
		b.setBookName(book.getBookName());
		b.setAuthor(book.getAuthor());
		b.setPublisher(book.getPublisher());
		b.setPrice(book.getPrice());
		b.setCnum(book.getCnum());
		b.setSnum(book.getSnum());
		b.setSummary(book.getSummary());
		if (this.getPhoto() != null) {
			FileInputStream fis = new FileInputStream(this.getPhoto());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			b.setPhoto(buffer);
		}
		bookservice.updateBook(b);
		this.setMessage("修改成功！");
		return SUCCESS;
	}
}
