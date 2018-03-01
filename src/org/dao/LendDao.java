package org.dao;

import java.util.List;

import org.vo.Book;
import org.vo.Lend;
import org.vo.Student;

/**
 * 
 * @ClassName: LendDao
 * @Description: lend�ӿ���
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public interface LendDao {
	/**
	 * 
	 * @Title: selectBook
	 * @Description: ��ҳ��ѯָ������֤�ŵĶ�������ͼ�����Ϣ
	 * @param @param readerId
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List<Lend> ��������
	 * @throws
	 */
	public List<Lend> selectBook(String readerId, int pageNow, int pageSize);

	/**
	 * 
	 * @Title: selectBookSize
	 * @Description: ��ѯָ������֤�ŵĶ�������ͼ�������
	 * @param @param readerId
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int selectBookSize(String readerId);

	/**
	 * 
	 * @Title: addLend
	 * @Description: ����
	 * @param @param lend
	 * @param @param book
	 * @param @param student ����
	 * @return void ��������
	 * @throws
	 */
	public void addLend(Lend lend, Book book, Student student);

	/**
	 * 
	 * @Title: selectByBookISBN
	 * @Description: ����ͼ��ID��ѯLend����Ϣ
	 * @param @param ISBN
	 * @param @return ����
	 * @return Lend ��������
	 * @throws
	 */
	public Lend selectByBookISBN(String ISBN);

	/**
	 * 
	 * @Title: selectByBookId
	 * @Description: ����ͼ��id��ѯLend��Ϣ
	 * @param @param bookId
	 * @param @return ����
	 * @return Lend ��������
	 * @throws
	 */
	public Lend selectByBookId(String bookId);
}
