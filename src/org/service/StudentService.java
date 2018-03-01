package org.service;

import org.vo.Student;

/**
 * 
 * @ClassName: StudentService
 * @Description: 业务逻辑接口StudentService
 * @author litengbin
 * @date 2017年6月10日
 * 
 */
public interface StudentService {
	/**
	 * 
	 * @Title: selectStudent
	 * @Description: 查询读者信息
	 * @param @param readerId
	 * @param @return 参数
	 * @return Student 返回类型
	 * @throws
	 */
	public Student selectStudent(String readerId);
}
