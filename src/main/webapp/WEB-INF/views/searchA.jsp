<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="sun.awt.AppContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./common/common.jsp" %>
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
    
    <title><s:text name="title"/></title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 
	<script language="javascript" src="<%=request.getContextPath()%>/manage/js/main.js"> </script>
	 -->
	<link rel="stylesheet" href="./css/common.css" type="text/css">
	<link rel="stylesheet" href="./css/button.css" type="text/css">
	<script type="text/javascript">
	function select_onchange(){
	var myform=document.getElementById("langForm");
	myform.action="langLocale";
	myform.submit();
	}
	</script>
  </head>
  
  <body>
  <s:form id="langForm">
  <div class="W3_MEND">
  <span class="W3_HEAD">
  <s:text name="language"/>
  <select id="select" name="request_locale" onchange="select_onchange()">
  <option value="request_locale" selected="selected">${request_locale}</option>
  <option value="zh_CN"><s:text name="zhcn"/></option>
  <option value="en_US"><s:text name="enus"/></option>
  </select>&ensp;<a href="login"><s:text name="login"/></a>|<a href="regtion"><s:text name="register"/></a>
  </span>
  </div>
  </s:form>
  <div class="W3_IN">
  <img src="./images/logo.png" >
  <div class="W3_TB">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <a href="#"><s:text name="ISP_Internet"/></a>
   &nbsp;&nbsp;
   <a href="#"><s:text name="Service_Requirement"/></a>
  </div>
  <div>
  <s:form action="exSearch" method="post" id="MyForm">
  <table align="center">
  <tr>
  <th>
  <div>
  <input type="text" class="W3_text" style="height:48px;width:330px">
  </div>
  </th>
  <th>
  <div class="button">
	<a href="#">
		<span class="button red">
			<span class="icon" style="background-image: url(./images/down-icon.png);"></span>
			<span class="text">
				<s:text name="search"/>
			</span>
		</span>
	</a>
	</div>
	</th>
	</tr>
	</table>
  </s:form>
  </div>
  <br/>
 <img src="./images/logo3.png" >
  <br/>​
  </div>
  <div class="W3_FOOT" align="left">
  <hr class="W3_HR" size="1"> 
  <span class="W3_SPAN">
  <%@ include file="./common/footer.jsp" %>
  </span>
  </div>
  </body>
</html>
