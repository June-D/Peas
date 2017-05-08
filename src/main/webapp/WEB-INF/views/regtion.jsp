<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-tags" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="./common/common.jsp" %>
    <title><s:text name="title"/></title>
	<link rel="stylesheet" href="./css/common.css" type="text/css">
	<link rel="stylesheet" href="./css/button.css" type="text/css">
	<script language="javascript" src="./js/regtion.js"></script>
  </head>
  
  <body>
    <div class="W3_MEND">
  <span class="W3_LIHEAD">
	<a href="search" ><s:text name="publicity"/></a>
  </span>
  </div>
   <br/>
 <img src="./images/logo3.png" >
  <br/>
  <br/>
  <s:form action="exregtion" method="post" id="regtionForm">
  <div style="float: left;width: 50%"align="right">
			<video controls="controls" autoplay="autoplay" loop="loop"
				preload="auto" src="./videos/advertisement1.mp4" width="90%" height="70%"></video>
		</div>
  	<div class="W3_LIDIV"> 
  		<s:fielderror cssStyle="color:red"/>
  		<table align="center">
  			<tr>
  				<th>
  					<span style="color:red">*</span>
  					<s:text name="userName"/>：
  					<br>
  				</th>
  				<th>
  					<input type="text" class="W3_LITEXT"
  						name="regtionForm.userName" onkeypress="return keydown()" maxlength="20" value="${regtionForm.userName}">
  				</th>
  			</tr>
  			<tr>
  				<th>
  					<span style="color:red">*</span>
  					<s:text name="email"/>：
  					<br>
  				</th>
  				<th>
  					<input type="text" class="W3_LITEXT"
  						name="regtionForm.email" onkeypress="return keydown()" maxlength="40" value="${regtionForm.email}">
  				</th>
  			</tr>
  			<tr>
  				<th>
  					<span style="color:red">*</span>
  					<s:text name="password"/>：
  					<br>
  				</th>
  				<th>
  					<input type="password" class="W3_LITEXT"
  						name="regtionForm.password" onkeypress="return keydown()" maxlength="12" value="${regtionForm.password}">
  				</th>
  			</tr>
  			<tr>
  				<th>
  					<span style="color:red">*</span>
  					<s:text name="repassword"/>：
  					<br>
  				</th>
  				<th>
  					<input type="password" class="W3_LITEXT"
  						name="regtionForm.repassword" maxlength="12" onkeypress="return keydown()" value="${regtionForm.repassword}">
  				</th>
  			</tr>
  			<tr>
  				<th>
  					<span style="color:red">*</span>
  					<s:text name="validationCode"/>：
  					<br></th>
  				<th>
  					<input type="text" class="W3_LITEXT"
  						name="regtionForm.validatorCode" onkeypress="return keydown()" maxlength="6">
  				</th>
  			</tr>
  			<tr>
  				<th align="center">
  					<img style="cursor:pointer;" title="点击更换" onclick="javascript:refresh(this);" src="validateCode">
  				</th>
  				<th align="right">
  					<a href="javaScript:tosubmit() ">
  						<span class="button red">
  							<span class="icon"
  								style="background-image: url(./images/down-icon.png);">
  							</span>
  							<span class="text"><s:text name="registerButton"/></span>
  						</span>
  					</a>
  				</th>
  			</tr>
  		</table>
  	</div>
  </s:form>
  <div class="W3_FOOT" align="left">
  <hr class="W3_HR" size="1"> 
  <span class="W3_SPAN">
  <%@ include file="./common/footer.jsp" %>
  </span>
  </div>
  </body>
</html>
