<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="./common/common.jsp" %>
    
    <title><s:text name="MIN_RE_TITLE"></s:text></title>
	<link rel="stylesheet" href="./css/changepass.css" type="text/css">
	<link rel="stylesheet" href="./css/button.css" type="text/css">
	<script language="javascript" src="./js/jquery.min.js"></script>
	<script language="javascript" src="./js/resetpass.js"></script>
	<script>
	function run(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
		document.getElementById('Umessage').style.display="none";
		document.getElementById('Mmessage').style.display="none";
	}
	jQuery(document).ready(function($) {
		
		$('.theme-poptit .close').click(function(){
			$('.theme-popover-mask').fadeOut(100);
			$('.theme-popover').slideUp(200);
		})
	
	})
	</script>
  </head>
  
  <body onload="run()" style="text-align: center;">

    <!-- 忘记密码部分 -->
  <div class="theme-popover">
     <div class="theme-poptit">
          <a href="javascript:;" title="关闭" class="close">×</a>
          <h3><s:text name="MIN_TITLE"/>&nbsp;&nbsp;${_NWND_USER_NAME }</h3>
          <span id="Umessage" style=" color:red;"><s:text name="MIN_RE_NEW_MINLENGTH"/></span>
          <span id="Mmessage" style=" color:red;"><s:text name="MIN_RE_NEW_REPASSCHECK"/></span>
     </div>
     
     <div class="theme-popbod dform">
     
           <form class="theme-signin"  id="chpForm" action="inputNewPassword" method="post">
                <ol>
                     <li><s:text name="MIN_RE_NEW_MINLENGTH"></s:text></li>
                     <li><strong><s:text name="MIN_RE_NEW_PASS"/>：</strong><input id="newpass" class="ipt" type="password"  name="newpass" value="${newpass }" size="20" /></li>
                     <li><strong><s:text name="MIN_RE_NEW_RPASS"/>：</strong><input id="rnewpass" class="ipt" type="password" name="rnewpass" value="${rnewpass }" size="20" /></li>
                     <li><a id="button" href="javaScript:submit()">
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
