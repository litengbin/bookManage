package org.dao;

import org.vo.Login;

/**
 * 
 * @ClassName: LoginDao
 * @Description: Login接口类
 * @author litengbin
 * @date 2017年5月13日
 * 
 */
public interface LoginDao {
	/**
	 * 
	 * @Title: checkLogin
	 * @Description: 验证用户信息
	 * @param @param name
	 * @param @param password
	 * @param @return 参数
	 * @return Login 返回类型
	 * @throws
	 */
	public Login checkLogin(String name, String password);
}
