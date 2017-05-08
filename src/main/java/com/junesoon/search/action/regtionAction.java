package com.junesoon.search.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.form.RegtionForm;
import com.junesoon.search.logic.RegtionLogic;
import com.junesoon.search.util.LoggerMessage;
import com.junesoon.search.util.StringUtil;
import com.junesoon.search.util.Mail.SendMail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ע�Ṧ�ܡ�
 * 
 * @author NDNW.
 * 
 */
@SuppressWarnings("restriction")
@Scope("prototype")
@Controller("regtionAction")
@Namespace("/")
public class regtionAction extends ActionSupport {

	/**
	 * ���л�ID��
	 */
	private static final long serialVersionUID = 5644667018837309628L;

	// ��־�ļ�
	private static Logger logger = Logger.getLogger(loginAction.class);

	// �ŵ�session�е�key
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";

	@Resource
	private RegtionForm regtionForm;

	private RegtionLogic regtionLogic = new RegtionLogic();

	public RegtionForm getRegtionForm() {
		return regtionForm;
	}

	public void setRegtionForm(RegtionForm regtionForm) {
		this.regtionForm = regtionForm;
	}

	/**
	 * ��ʼ��ע��ҳ�档
	 * 
	 * @return ע��ҳ�档
	 * @throws Exception
	 * 
	 */
	@Action("regtion")
	public String regtion() throws Exception {
		logger.info(LoggerMessage.REGTION_INITIALIZE_VIEW);
		return "regtion.jsp";
	}

	/**
	 * ��֤�û�ע����Ϣ���洢�û�ע����ʱ��Ϣ�������û�ע����֤�ʼ�
	 * 
	 * @return
	 * @throws Exception
	 */
	@Action("exregtion")
	public String exregtion() {
		try {
			// ������ϢУ��
			boolean result = this.validation(regtionForm);

			if (!result) {// ��֤δͨ��
				// ����ע��ҳ��
				return "regtion";
			} else {
				logger.info(LoggerMessage.REGTION_REGTION_EXEC);
				// ���÷���existUser��֤�û����Ƿ��Ѿ�����
				boolean b = regtionLogic.existUser(regtionForm);
				if (b) {
					addFieldError("userName", this.getText("REGTION_VALIDATORCODE_EXIST"));
					return "regtion";
				} else {
					//����û������Ƿ��Ѿ�����
					boolean m =regtionLogic.checkMailAddress(regtionForm.getEmail());
					if(m){
						//���ʼ���ַ�Ѿ����ڣ�����ע��ҳ�棬��ʾ�û���ַ�Ѿ�����
						addFieldError("userName", this.getText("REGTION_MAILADDRESS_EXIST"));
						return "regtion";
					}else{
						// ����remberUserInfo���������û���Ϣ������ʱ��
						String idString = regtionLogic.remberUserInfo(regtionForm);
						String urlString="http://localhost:8080/Doreamon/beginRegtion?ID="+idString;
						// ���ù�������SendMail�����ʼ�
						String toAddress = regtionForm.getEmail();
						String subject = "New Word New Dream ���������û�ע�ἤ���ʼ�";
						// TODO ��URL��Ϣд��HTML��
						String path=this.getClass().getClassLoader().getResource("").toString().split("/WEB-INF")[0];
						path=path.split("file:")[1];
						String mailTemplate = path+"/template_mail.html";
						logger.info(LoggerMessage.REGTION_ENDMAIL_EXEC);
						boolean send = SendMail.send(toAddress, subject, mailTemplate);
						if (!send) {
							// �ʼ�����ʧ�ܷ���ע��ҳ��
							logger.info(LoggerMessage.REGTION_ENDMAIL_ERR);
							addFieldError("", this.getText("REGTION_SENDMAIL_ERR"));
							return "fail";
						} else {
							// �ʼ����ͳɹ�����ת����ʾҳ��
							System.out.println("�ʼ����ͳɹ�");
							regtionLogic.regtion(regtionForm, "0");// �û��ٵ�¼
							return "success";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	

	/**
	 * �û�����ע���˻�
	 * @return ʧ�ܣ�ע��ҳ��   �ɹ�����ҳ��
	 */
	@Action("beginRegtion")
	public String beginRegtion() {
		try {
			// ��ȡURL����
			String idString = (String) ServletActionContext.getRequest()
					.getAttribute("ID");
			// ����getOutUserInfo������֤�û�ע����Ϣ
			String name = regtionLogic.getOutUserInfo(idString);
			if (name != null) {
				TabUserinfoBase userinfoBase = (TabUserinfoBase) regtionLogic
						.updateUserInfo(name);
				if (userinfoBase == null) {
					addFieldError("", this.getText("REGTION_VALIDATORCODE_FAILED"));
					return "regtion";
				} else {
					//���û���Ϣ����session��
					String userName = userinfoBase.getUserName();
					String email = userinfoBase.getEmail();
					ActionContext actionContext = ActionContext.getContext();
					actionContext.getSession().put("_NWND_USER_NAME", userName);
					actionContext.getSession().put("_NWND_USER_EMAIL", email);
					actionContext.getSession().put("_NWND_USER_INFO", userinfoBase);
					return "search";
				}
			} else {
				logger.info(LoggerMessage.REGTION_REGTION_TIMOUT);
				addFieldError("", this.getText("REGTION_REGTION_TIMOUT"));
				return "regtion";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
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
	public boolean validation(RegtionForm regForm) {

		if (StringUtil.IfstrNull(regForm.getUserName())) {
			this.addFieldError("regtionForm.userName",
					this.getText("LOGIN_USERNAME_INPUT"));

			return false;
		}
		if (regForm.getUserName().length() > 20) {
			this.addFieldError("userName",
					this.getText("REGTION_MAXUSERNAME_INPUT"));

			return false;
		}
		if (StringUtil.IfstrNull(regForm.getEmail())) {

			addFieldError("email", this.getText("REGTON_EMAIL_INPUT"));

			return false;
		} else if (!StringUtil.IfmatchMail(regForm.getEmail())) {

			addFieldError("email", this.getText("REGTON_EMAILCHECK_INPUT"));

			this.regtionForm.setEmail("");

			return false;
		}
		if (StringUtil.IfstrNull(regForm.getPassword())) {

			addFieldError("password", this.getText("LOGIN_PASSWORD_INPUT"));

			return false;
		}
		if (StringUtil.IfstrNull(regForm.getRepassword())) {

			addFieldError("repassword",
					this.getText("REGTION_REPASSWORD_INPUT"));

			return false;
		}
		if (!regForm.getPassword().equals(regForm.getRepassword())) {

			addFieldError("repassword",
					this.getText("REGTION_CHECKPASSWORD_INPUT"));

			this.regtionForm.setRepassword("");

			return false;
		}
		if (regForm.getPassword().length() > 12) {

			addFieldError("password",
					this.getText("REGTION_MAXLENGTHPASSWORD_INPUT"));

			return false;
		}
		if (regForm.getPassword().length() < 6) {

			addFieldError("password",
					this.getText("REGTION_MINLENGTHPASSWORD_INPUT"));

			return false;
		}
		if (!StringUtil.IfstrNull(regForm.getValidatorCode())) {

			String codeString = regForm.getValidatorCode();

			if (!ActionContext.getContext().getSession().get(RANDOMCODEKEY)
					.equals(codeString.toUpperCase())) {

				addFieldError("validatorCode",
						this.getText("REGTION_VALIDATORCODE_INPUT"));

				return false;

			}
		} else {
			addFieldError("validatorCode",
					this.getText("REGTION_VALIDATORCODE_INPUT"));

			return false;
		}

		return true;
	}
}
