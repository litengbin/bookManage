package org.service.impl;

import org.dao.LoginDao;
import org.service.LoginService;
import org.vo.Login;

/**
 * 
 * @ClassName: LoginServiceImpl
 * @Description: ҵ���߼��ӿ�LoginService��ʵ����
 * @author litengbin
 * @date 2017��6��9��
 * 
 */
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	@Override
	public Login checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.checkLogin(username, password);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
