package org.service;

import org.vo.Book;

/**
 * 
 * @ClassName: BookService
 * @Description: ҵ���߼��ӿ�BookService
 * @author litengbin
 * @date 2017��6��10��
 * 
 */
public interface BookService {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: ��ѯͼ����Ϣ
	 * @param @param ISBN
	 * @param @return ����
	 * @return Book ��������
	 * @throws
	 */
	public Book selectBook(String ISBN);

	/**
	 * 
	 * @Title: addBook
	 * @Description: ���ͼ��
	 * @param @param book ����
	 * @return void ��������
	 * @throws
	 */
	public void addBook(Book book);

	/**
	 * 
	 * @Title: deleteBook
	 * @Description: ɾ��ͼ��
	 * @param @param ISBN ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteBook(String ISBN);

	/**
	 * 
	 * @Title: updateBook
	 * @Description: �޸�ͼ��
	 * @param @param book ����
	 * @return void ��������
	 * @throws
	 */
	public void updateBook(Book book);
}
