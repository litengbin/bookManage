package org.action;

import java.util.Map;

import org.service.LoginService;
import org.vo.Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: LoginAction
 * @Description: ��½action��
 * @author litengbin
 * @date 2017��6��9��
 * 
 */
public class LoginAction extends ActionSupport {
	private Login login;
	private String message;// ������ʾ��֤������Ϣ
	private LoginService loginservice;

	/**
	 * �����û������execute����
	 */
	public String execute() throws Exception {
		// LoginDao loginDao = new LoginDaoImpl();//
		// ����Ϊ��Ŀ�����ݵĽӿ�(DAO�ӿ�)�����ڴ������������ݿ���һЩ����
		Login l = loginservice.checkLogin(login.getName(), login.getPassword());
		if (l != null) { // �����½�ɹ�
			// ��ûỰ���������浱ǰ��¼�û�����Ϣ
			Map session = ActionContext.getContext().getSession();
			session.put("login", l);
			// return SUCCESS;
			// ��½�ɹ����жϽ�ɫΪ����Ա����ѧ����true��ʾ����Ա��false��ʾѧ��
			if (l.getRole()) {
				return "admin";// ����Ա��ݵ�¼
			} else {
				return "student";// ѧ����ݵ�¼
			}
		} else {
			return ERROR;// ��֤ʧ�ܷ����ַ���ERROR
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
	 * @Description: message��getter����
	 * @param @return ����
	 * @return String ��������
	 * @throws
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @Title: setMessage
	 * @Description: message��setter����
	 * @param @param message ����
	 * @return void ��������
	 * @throws
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @Title: getLogin
	 * @Description: login�����getter����
	 * @param @return ����
	 * @return Login ��������
	 * @throws
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * 
	 * @Title: setLogin
	 * @Description: login�����setter����
	 * @param @param login ����
	 * @return void ��������
	 * @throws
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * ������֤���ܣ���֤��½���������Ƿ�Ϊ��
	 */
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (login.getName() == null || login.getName().equals("")) {
			this.addFieldError("name", "�û�������Ϊ�գ�");
		} else if (login.getPassword() == null
				|| login.getPassword().equals("")) {
			this.addFieldError("password", "���벻��Ϊ�գ�");
		}
	}
}
