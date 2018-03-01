package org.service.impl;

import org.dao.LoginDao;
import org.service.LoginService;
import org.vo.Login;

/**
 * 
 * @ClassName: LoginServiceImpl
 * @Description: 业务逻辑接口LoginService的实现类
 * @author litengbin
 * @date 2017年6月9日
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
