package org.service;

import org.vo.Login;

/**
 * 
 * @ClassName: LoginService
 * @Description: ҵ���߼��ӿ�LoginService
 * @author litengbin
 * @date 2017��6��9��
 * 
 */
public interface LoginService {
	/**
	 * 
	 * @Title: checkLogin
	 * @Description: ��¼���
	 * @param @param username
	 * @param @param password
	 * @param @return ����
	 * @return Login ��������
	 * @throws
	 */
	public Login checkLogin(String username, String password);
}
