package org.dao;

import org.vo.Login;

/**
 * 
 * @ClassName: LoginDao
 * @Description: Login�ӿ���
 * @author litengbin
 * @date 2017��5��13��
 * 
 */
public interface LoginDao {
	/**
	 * 
	 * @Title: checkLogin
	 * @Description: ��֤�û���Ϣ
	 * @param @param name
	 * @param @param password
	 * @param @return ����
	 * @return Login ��������
	 * @throws
	 */
	public Login checkLogin(String name, String password);
}
