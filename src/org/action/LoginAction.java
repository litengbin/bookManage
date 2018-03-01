package org.action;

import java.util.Map;

import org.service.LoginService;
import org.vo.Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: LoginAction
 * @Description: 登陆action类
 * @author litengbin
 * @date 2017年6月9日
 * 
 */
public class LoginAction extends ActionSupport {
	private Login login;
	private String message;// 用于显示验证错误信息
	private LoginService loginservice;

	/**
	 * 处理用户请求的execute方法
	 */
	public String execute() throws Exception {
		// LoginDao loginDao = new LoginDaoImpl();//
		// 该类为项目与数据的接口(DAO接口)，用于处理数据与数据库表的一些操作
		Login l = loginservice.checkLogin(login.getName(), login.getPassword());
		if (l != null) { // 如果登陆成功
			// 获得会话，用来保存当前登录用户的信息
			Map session = ActionContext.getContext().getSession();
			session.put("login", l);
			// return SUCCESS;
			// 登陆成功，判断角色为管理员还是学生，true表示管理员，false表示学生
			if (l.getRole()) {
				return "admin";// 管理员身份登录
			} else {
				return "student";// 学生身份登录
			}
		} else {
			return ERROR;// 验证失败返回字符串ERROR
		}
	}

	public LoginService getLoginservice() {
		return loginservice;
	}

	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}

	/**
	 * 
	 * @Title: getMessage
	 * @Description: message的getter方法
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @Title: setMessage
	 * @Description: message的setter方法
	 * @param @param message 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @Title: getLogin
	 * @Description: login对象的getter方法
	 * @param @return 参数
	 * @return Login 返回类型
	 * @throws
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * 
	 * @Title: setLogin
	 * @Description: login对象的setter方法
	 * @param @param login 参数
	 * @return void 返回类型
	 * @throws
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * 增加验证功能，验证登陆名和密码是否为空
	 */
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (login.getName() == null || login.getName().equals("")) {
			this.addFieldError("name", "用户名不能为空！");
		} else if (login.getPassword() == null
				|| login.getPassword().equals("")) {
			this.addFieldError("password", "密码不能为空！");
		}
	}
}
