package org.service;

import org.vo.Student;

/**
 * 
 * @ClassName: StudentService
 * @Description: ҵ���߼��ӿ�StudentService
 * @author litengbin
 * @date 2017��6��10��
 * 
 */
public interface StudentService {
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
