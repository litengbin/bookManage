package org.service.impl;

import org.dao.StudentDao;
import org.service.StudentService;
import org.vo.Student;

/**
 * 
 * @ClassName: StudentServiceImpl
 * @Description: 业务逻辑接口StudentService的实现类
 * @author litengbin
 * @date 2017年6月10日
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
