package org.dao;

import org.vo.Student;

/**
 * 
 * @ClassName: StudentDao
 * @Description: student接口类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public interface StudentDao {
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
