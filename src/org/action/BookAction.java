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
 * @Description: ͼ��action��
 * @author litengbin
 * @date 2017��5��12��
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
	 * @Title: getPhoto
	 * @Description: photo��getter����
	 * @param @return ����
	 * @return File ��������
	 * @throws
	 */
	public File getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @Title: setPhoto
	 * @Description: photo��setter����
	 * @param @param photo ����
	 * @return void ��������
	 * @throws
	 */
	public void setPhoto(File photo) {
		this.photo = photo;
	}

	/**
	 * 
	 * @Title: getBook
	 * @Description: book��getter����
	 * @param @return ����
	 * @return Book ��������
	 * @throws
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * 
	 * @Title: setBook
	 * @Description: book��setter����
	 * @param @param book ����
	 * @return void ��������
	 * @throws
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	// BookDao bookDao = new BookDaoImpl();

	/**
	 * 
	 * @Title: addBook
	 * @Description: ���ͼ����Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addBook() throws Exception {
		if (book.getISBN() == null || "".equals(book.getISBN())) {
			this.setMessage("ISBNΪ��!���ʧ��!");
			return SUCCESS;
		}
		Book bo = bookservice.selectBook(book.getISBN());
		if (bo != null) {// �ж�Ҫ��ӵ�ͼ���Ƿ��Ѿ�����
			this.setMessage("ISBN�Ѿ����ڣ�");
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
		this.setMessage("��ӳɹ���");
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
	 * @Description: ɾ��ͼ����Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String deleteBook() throws Exception {
		if (book.getISBN() == null || book.getISBN().equals("")) {
			this.setMessage("������ISBN��");
			return SUCCESS;
		}
		Book bo = bookservice.selectBook(book.getISBN());
		if (bo == null) {// �����ж��Ƿ���ڸ�ͼ��
			this.setMessage("Ҫɾ����ͼ�鲻����");
			return SUCCESS;
		} else if (lendservice.selectByBookISBN(book.getISBN()) != null) {
			this.setMessage("��ͼ���Ѿ���������ʲ���ɾ��ͼ����Ϣ��");
			return SUCCESS;
		}
		bookservice.deleteBook(book.getISBN());
		this.setMessage("ɾ���ɹ���");
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: selectBook
	 * @Description: ͼ���ѯ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String selectBook() throws Exception {
		Book onebook = bookservice.selectBook(book.getISBN());
		if (onebook == null) {
			this.setMessage("�����ڸ�ͼ�飡");
			return SUCCESS;
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("onebook", onebook);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getImage
	 * @Description:���ͼ���image
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
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
	 * @Description: �޸�ͼ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateBook() throws Exception {
		Book b = bookservice.selectBook(book.getISBN());
		if (b == null) {
			this.setMessage("Ҫ�޸ĵ�ͼ�鲻���ڣ����Ȳ鿴�Ƿ���ڸ�ͼ�飡");
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
		this.setMessage("�޸ĳɹ���");
		return SUCCESS;
	}
}
