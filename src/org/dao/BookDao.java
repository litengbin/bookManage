package org.dao;

import org.vo.Book;

/**
 * 
 * @ClassName: BookDao
 * @Description: book�ӿ���
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public interface BookDao {
	/**
	 * 
	 * @Title: addBook
	 * @Description: ׷��ͼ����Ϣ
	 * @param @param book ����
	 * @return void ��������
	 * @throws
	 */
	public void addBook(Book book);

	/**
	 * 
	 * @Title: deleteBook
	 * @Description: ɾ��ͼ����Ϣ
	 * @param @param ISBN ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteBook(String ISBN);

	/**
	 * 
	 * @Title: updateBook
	 * @Description: �޸�ͼ����Ϣ
	 * @param @param book ����
	 * @return void ��������
	 * @throws
	 */
	public void updateBook(Book book);

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
}
