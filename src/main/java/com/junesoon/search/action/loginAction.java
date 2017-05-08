package com.junesoon.search.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.form.LoginForm;
import com.junesoon.search.logic.LoginLogic;
import com.junesoon.search.util.LoggerMessage;
import com.junesoon.search.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��¼���ܡ�
 * 
 * @author NDNW��
 * 
 */
@Scope("prototype")
@Controller("loginAction")
public class loginAction extends ActionSupport {

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 8068231547557796217L;

	// ��־�ļ�
	private static Logger logger = Logger.getLogger(loginAction.class);

	@Resource
	private LoginForm loginForm;

	LoginLogic loginLogic = new LoginLogic();

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	/**
	 * ��ת����¼ҳ�档
	 * 
	 * @return ��¼ҳ�档
	 * @throws Exception
	 *             ��
	 */
	@Action("login")
	public String login() throws Exception {
		logger.info(LoggerMessage.LOGIN_RETURN_PAGES);
		return "login.jsp";
	}

	@Action("exlogin")
	public String exlogin() throws Exception {

		logger.info(LoggerMessage.LOGIN_METHOD_START);

		// ������ϢУ��
		boolean result = this.validation(loginForm.getUserName(),
				loginForm.getPassword());

		if (!result) {// ��֤��ͨ�����ص�¼ҳ��

			return "login";
		}
		// �����߼��㷽����֤�û���¼��Ϣ
		TabUserinfoBase userinfoBase = loginLogic.loginCheck(
				loginForm.getUserName(), loginForm.getPassword());

		if (userinfoBase == null) {// �û���֤δͨ��

			addFieldError("", this.getText("LOGIN_USER_CHECK"));

			return "login";
		} else {
			//���û���Ϣд��Session
			ActionContext.getContext().getSession().put("_NWND_USER_NAME", userinfoBase.getUserName());
			ActionContext.getContext().getSession().put("_NWND_USER_INFO", userinfoBase);
			//�ж��û��ǹ�ѡ��ס�ҵ�ѡ��
			String rember=loginForm.getRemberMe();
			String userName=loginForm.getUserName();
			String password=loginForm.getPassword();
			if("true".equals(rember)){//��ס��
				String userString=userName+"-"+password+"-"+rember;
				Cookie cookit=new Cookie("remberUser", userString);
				//�洢7��
				cookit.setMaxAge(7*24*3600);
				//���͵��ͻ���
				ServletActionContext.getResponse().addCookie(cookit);
			}else{
				//��ȡCookie,����ס�ҵ�Cookieɾ��
				Cookie cookit=new Cookie("remberUser", null);
				cookit.setMaxAge(0);
				//���͵��ͻ���
				ServletActionContext.getResponse().addCookie(cookit);
			}
			return "search";
		}

	}

	/**
	 * ҳ��������ϢУ�顣
	 * 
	 * @param userName
	 *            ��
	 * @param password
	 *            ��
	 * @return ��֤�����
	 */
	public boolean validation(String userName, String password) {

		if (StringUtil.IfstrNull(userName) && !StringUtil.IfstrNull(password)) {
			addFieldError("userName", this.getText("LOGIN_USERNAME_INPUT"));

			return false;
		}
		if (StringUtil.IfstrNull(password) && !StringUtil.IfstrNull(userName)) {

			addFieldError("password", this.getText("LOGIN_PASSWORD_INPUT"));

			return false;
		}
		if (StringUtil.IfstrNull(password) && StringUtil.IfstrNull(userName)) {

			addFieldError("", this.getText("LOGIN_USERNAMEPASSWORD_INPUT"));

			return false;
		}

		return true;
	}

}
