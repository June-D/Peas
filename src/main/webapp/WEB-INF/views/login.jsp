<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 6 ]>html class=“ie ielt9 ielt8 ielt7 ie6” lang=“zh-cn”><![endif]-->
<!--[if IE 7 ]><html class=“ie ielt9 ielt8 ie7” lang=“zh-cn”><![endif]-->
<!--[if IE 8 ]><html class=“ie ielt9 ie8” lang=“zh-cn”><![endif]-->
<!--[if IE 9 ]><html class=“ie ie9” lang=“zh-cn”><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang=“zh-cn”>
<!--<![endif]-->
  <head>
  	<%@ include file="./common/common.jsp" %>
  	<title><s:text name="title"/></title>
	<script language="javascript" src="./js/login.js"></script>
	<script language="javascript" src="./js/jquery.min.js"></script>
	<link rel="stylesheet" href="./css/common.css" type="text/css">
	<link rel="stylesheet" href="./css/button.css" type="text/css">
	<link rel="stylesheet" href="./css/changepass.css" type="text/css">
	<script>
	jQuery(document).ready(function($) {
		$('.forget_pass').click(function(){
			$('.theme-popover-mask').fadeIn(100);
			$('.theme-popover').slideDown(200);
		})
		$('.theme-poptit .close').click(function(){
			$('.theme-popover-mask').fadeOut(100);
			$('.theme-popover').slideUp(200);
		})
	
	})
	</script>
  </head>
  <body onload="getsubStr('remberUser');">
  <div class="W3_MEND">
  <span class="W3_LIHEAD">
 	<a href="search" ><s:text name="publicity"></s:text></a>
  </span>
  </div>
   <br/>
 <img src="./images/logo3.png" >
  <br/>
  <br/>
  
  <s:form action="exlogin" method="post" id="myForm" >
  <div style="float: left;width: 50%" align="right">
			<video controls="controls" autoplay="autoplay" loop="loop"
				preload="auto" src="./videos/advertisement2.mp4" width="90%" height="70%"></video>
		</div>
  <div class="W3_LIDIV">
  <s:fielderror cssStyle="color:red"/>
  
  <table align="center" >
  <tr>
  <th></th>
  <th align="left">
 	<font size="2"><s:text name="prompting"/><a href="regtion"><font color="#0000EB"><s:text name="register"/></font></a></font>
  </th>
  </tr>
  <tr>
  <th>
  <span style="color:red">*</span> <s:text name="userName"/>：<br>
  </th>
  <th>
  <input type="text" class="W3_LITEXT" id="userName" onkeypress="return keydown()" name="loginForm.userName" maxlength="20" value="${loginForm.userName}">
  </th>
  </tr>
  <tr>
  <th>
  <span style="color:red">*</span> <s:text name="password"/>：<br>
  </th>
  <th>
  <input type="password" id="password" onkeypress="return keydown()" class="W3_LITEXT" name="loginForm.password" maxlength="12" ><div id="capital" style="display:none;">大写锁定已开启</div>
  </th>
  </tr>
  <tr>
  <th>
  </th>
  <th>
  	<input type="checkbox" checked="checked" id="checkbox" name="loginForm.remberMe" value="true">
  	<font class="W3_LIFONT"><s:text name="remberUserName"/></font>
  	&nbsp;&nbsp;&nbsp;&nbsp;
  	<a href="javascript:;" class="forget_pass">
  		<font class="W3_LIFONT"><s:text name="forgetPassword"/></font>
  	</a>
  </th>
  </tr>
  <tr>
  <th>
  </th>
  <th>
  <a id="button" href="javaScript:tosubmit() ">
		<span class="button red">
			<span class="icon" style="background-image: url(./images/down-icon.png);"></span>
			<span class="text">
				<s:text name="loginButton"/>
			</span>
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
  
  <!-- 忘记密码部分 -->
  <div class="theme-popover">
     <div class="theme-poptit">
          <a href="javascript:;" title="关闭" class="close">×</a>
          <h3><s:text name="MIN_TITLE"/></h3>
          <span id="Umessage" style=" color:red;"><s:text name="LOGIN_USERNAME_INPUT"/></span>
          <span id="Mmessage" style=" color:red;"><s:text name="REGTON_EMAIL_INPUT"/></span>
          <span id="Cmessage" style=" color:red;"><s:text name="REGTON_EMAILCHECK_INPUT"/></span>
     </div>
     
     <div class="theme-popbod dform">
     
           <form class="theme-signin"  id="chpForm" action="changePassword" method="post">
                <ol>
                     <li><h4><s:text name="MIN_INFO"/></h4></li>
                     <li><strong><s:text name="userName"/>：</strong><input id="inputusername" class="ipt" type="text" name="puserName" value="${puserName }" size="20" /></li>
                     <li><strong><s:text name="email"/>：</strong><input id="inputmail" class="ipt" type="text" name="pmail" value="${pmail }" size="20" /></li>
                     <li><a id="button" href="javaScript:toCPsubmit()">
						 <span class="button red">
						 <span class="text">
					     <s:text name="makeSure"/>
						 </span>
						 </span>
  						</a>
  					</li>
                </ol>
           </form>
     </div>
</div>
<div class="theme-popover-mask"></div>
<!-- 忘记密码结束 -->
  
  </body>
</html>
