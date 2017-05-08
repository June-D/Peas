package com.junesoon.search.interceptor;

import java.util.Map;

import javax.interceptor.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * �û���¼��������
 * @author NDNW
 *
 */
@Interceptor
public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 8743924082114116407L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// ��ȡActionContext
		ActionContext context = ActionContext.getContext();
		// ��ȡMap���͵�session
		Map<String, Object> session = context.getSession();
		// �ж��û��Ƿ��¼
		if (session.get("_NWND_USER_INFO") != null) {
			// ����ִ�з���
			System.out.println("888");
			return invocation.invoke();
		}
		// ���ص�¼
		System.out.println("999");
		return "login";
	}

}