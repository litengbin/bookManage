package org.dao;

import org.vo.Student;

/**
 * 
 * @ClassName: StudentDao
 * @Description: student�ӿ���
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public interface StudentDao {
	/**
	 * 
	 * @Title: selectStudent
	 * @Description: ��ѯ������Ϣ
	 * @param @param readerId
	 * @param @return ����
	 * @return Student ��������
	 * @throws
	 */
	public Student selectStudent(String readerId);
}
