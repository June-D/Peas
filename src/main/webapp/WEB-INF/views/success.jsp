<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META HTTP-EQUIV="Refresh" CONTENT="7;URL=login">
<title>邮件发送成功！</title>
<style type="text/css">
body{		
background-color: #19a568;
text-align: center;
}
</style>
	<script type="text/javascript">
	function time(){
	var num=document.getElementById('num').innerHTML;

	if(num==0){
	alert(123);
	}
	num=num-1;
	document.getElementById('num').innerHTML=num;
	t=setTimeout(time,1000);

	}
	</script>
</head>

<body onload="time()">
<div style="height:100px;">  </div>
<div><img alt="500" src="./images/success.png"/></div>
<div><p style="font-size:42px; font-style:oblique; font-family:幼圆;color:white;">邮件已经发送成功，请注意查收！</p></div>
<hr  style="width:60%;" />
<p style="color:white;">提示：</p>
<p style="color:white;">邮件有效期为24小时</p>
<p style="color:white;">请您及时处理，以免给您造成不便！&ensp;
<span id="num" style="color: white;">8</span><font color="white">秒后自动跳转到登录页面</font> 
<a href="search"><img alt="返回" style="width:20px;" src="./images/undo.png"/></a></p>
<hr  style="width:60%;" />
</body>

</html>
