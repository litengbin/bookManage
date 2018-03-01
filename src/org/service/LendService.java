package org.service;

import java.util.List;

import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendService
 * @Description: ҵ���߼��ӿ�LendService
 * @author litengbin
 * @date 2017��6��10��
 * 
 */
public interface LendService {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: ��ѯͼ��
	 * @param @param readerId
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List selectBook(String readerId, int pageNow, int pageSize);

	/**
	 * 
	 * @Title: selectBookSize
	 * @Description: ����ͼ����
	 * @param @param readerId
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int selectBookSize(String readerId);

	/**
	 * 
	 * @Title: addLend
	 * @Description: ��ӽ����¼
	 * @param @param lend
	 * @param @param book
	 * @param @param student ����
	 * @return void ��������
	 * @throws
	 */
	public void addLend(Lend lend, Book book, Student student);

	/**
	 * 
	 * @Title: selectByBookId
	 * @Description: ��ѯ������Ϣ
	 * @param @param bookId
	 * @param @return ����
	 * @return Lend ��������
	 * @throws
	 */
	public Lend selectByBookId(String bookId);

	/**
	 * 
	 * @Title: selectByBookISBN
	 * @Description: ��ѯ������Ϣ
	 * @param @param ISBN
	 * @param @return ����
	 * @return Lend ��������
	 * @throws
	 */
	public Lend selectByBookISBN(String ISBN);
}
