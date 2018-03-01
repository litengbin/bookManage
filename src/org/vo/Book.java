package org.vo;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private String ISBN;
	private String bookName;
	private String author;
	private String publisher;
	private Double price;
	private Integer cnum;
	private Integer snum;
	private String summary;
	private byte[] photo;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String ISBN, String bookName, String author, String publisher,
			Double price, Integer cnum, Integer snum) {
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.cnum = cnum;
		this.snum = snum;
	}

	/** full constructor */
	public Book(String ISBN, String bookName, String author, String publisher,
			Double price, Integer cnum, Integer snum, String summary,
			byte[] photo) {
		this.ISBN = ISBN;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.cnum = cnum;
		this.snum = snum;
		this.summary = summary;
		this.photo = photo;
	}

	// Property accessors

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCnum() {
		return this.cnum;
	}

	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}

	public Integer getSnum() {
		return this.snum;
	}

	public void setSnum(Integer snum) {
		this.snum = snum;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}