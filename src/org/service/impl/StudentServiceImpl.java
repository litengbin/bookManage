package org.service.impl;

import org.dao.StudentDao;
import org.service.StudentService;
import org.vo.Student;

/**
 * 
 * @ClassName: StudentServiceImpl
 * @Description: ҵ���߼��ӿ�StudentService��ʵ����
 * @author litengbin
 * @date 2017��6��10��
 * 
 */
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student selectStudent(String readerId) {
		// TODO Auto-generated method stub
		return studentDao.selectStudent(readerId);
	}

}
