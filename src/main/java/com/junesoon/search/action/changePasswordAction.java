package com.junesoon.search.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.logic.ChangePasswordLogic;
import com.junesoon.search.util.LoggerMessage;
import com.junesoon.search.util.Mail.SendMail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��������Ĵ���
 * @author NDNW��
 *
 */
@Scope("prototype")
@Controller("changePasswordAction")
public class changePasswordAction extends ActionSupport {
	
		//�û���
		@Resource
		private String puserName;
		//�����ַ
		@Resource
		private String pmail;
		//������
		@Resource
		private String newpass;
		
		public String getPuserName() {
			return puserName;
		}

		public void setPuserName(String puserName) {
			this.puserName = puserName;
		}

		public String getPmail() {
			return pmail;
		}

		public void setPmail(String pmail) {
			this.pmail = pmail;
		}
		
		public String getNewpass() {
			return newpass;
		}

		public void setNewpass(String newpass) {
			this.newpass = newpass;
		}


		private static final Logger log = LoggerFactory
				.getLogger(changePasswordAction.class);
		
		ChangePasswordLogic changePasswordLogic=new ChangePasswordLogic();

	/**
	 * ���кš�
	 */
	private static final long serialVersionUID = -9067666530568958753L;

	@Action("changePassword")
	public String changePassword(){
		try {
			//��֤�û���Ϣ
			boolean b = changePasswordLogic.checkUserInfo(puserName, pmail);
			if(b){
				//��֤ͨ��
				String idString= changePasswordLogic.insertPassInfo(puserName, pmail);
				String urlString="http://localhost:8080/Doreamon/exchangePassword?ID="+idString;
				// ���ù�������SendMail�����ʼ�
				String subject = "New Word New Dream ���������û����������ȷ���ʼ�";
				// TODO ��URL��Ϣд��HTML��
				String path=this.getClass().getClassLoader().getResource("").toString().split("/WEB-INF")[0];
				path=path.split("file:")[1];
				String mailTemplate = path+"/template_mail.html";
				log.info(LoggerMessage.CHANGEPASS_SENDMAIL_EXEC);
				boolean send = SendMail.send(pmail, subject, mailTemplate);
				if (!send) {
					// �ʼ�����ʧ�ܷ���ע��ҳ��
					log.info(LoggerMessage.CHANGEPASS_ENDMAIL_ERR);
					addFieldError("", this.getText("REGTION_SENDMAIL_ERR"));
					return "regtion";
				} else {
					// �ʼ����ͳɹ�����ת����ʾҳ��
					System.out.println("�ʼ����ͳɹ�");
					return "success";
				}
			}else{
				//��֤δͨ��
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	@Action("exchangePassword")
	public String exchangePassword(){
		try {
			// ��ȡURL����
			String idString = (String) ServletActionContext.getRequest().getAttribute("ID");
			String flag=changePasswordLogic.readPassInfo(idString);
			if("out".equals(flag)){
				addFieldError("", this.getText("CHANGE_PASSWORD_TIMEOUT"));
				return "search";
			}else{
				if(flag==null){
					addFieldError("", this.getText("CHANGE_PASSWORD_NOTESIT"));
					return "search";
				}else{
					//���û���Ϣд��Session
					ActionContext.getContext().getSession().put("_NWND_USER_NAME", flag);
					return "resetPassword";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 * ��ת��ҳ�档
	 * @return �޸�����ҳ�档
	 */
	@Action("resetPassword")
	public String resetPassword(){
		return "resetPassword.jsp";
	}
	
	/**
	 * �޸�����
	 * @return ��½ҳ�档
	 */
	@Action("inputNewPassword")
	public String inputNewPassword(){
		try {
			String nameString=(String) ActionContext.getContext().get("_NWND_USER_NAME");
			boolean b=changePasswordLogic.updateUserInfo(nameString,newpass);
			if(b){
				addFieldError("", this.getText("RESET_NEW_PASS_SUCCESS"));
			}else{
				addFieldError("", this.getText("RESET_NEW_PASS_FAIL"));	
			}
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	
	
}
