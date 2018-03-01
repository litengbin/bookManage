package org.service;

import org.vo.Login;

/**
 * 
 * @ClassName: LoginService
 * @Description: 业务逻辑接口LoginService
 * @author litengbin
 * @date 2017年6月9日
 * 
 */
public interface LoginService {
	/**
	 * 
	 * @Title: checkLogin
	 * @Description: 登录检查
	 * @param @param username
	 * @param @param password
	 * @param @return 参数
	 * @return Login 返回类型
	 * @throws
	 */
	public Login checkLogin(String username, String password);
}
