<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META HTTP-EQUIV="Refresh" CONTENT="7;URL=search">
    <title>未找到请求资源</title>  
	<%@ include file="../common/common.jsp" %>
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
<style type="text/css">
body{		
background-color: #FFC301;
text-align: center;
}
</style>
</head>

<body onload="time()">
<div style="height:100px;">  </div>
<div><img alt="500" src="./images/yellowWin.png"/></div>
<div><p style="font-size:42px; font-style:oblique; font-family:幼圆;color:white;">404</p></div>
<hr  style="width:60%;" />
<p style="color:white;">主人！</p>
<p style="color:white;">人家已经很努力了</p>
<p style="color:white;">但是还是找不到您要访问的URL 
<span id="num" style="color: green;">8</span><font color="white">秒后自动跳转到主页面</font> &ensp; 
<a href="search"><img  alt="返回" style="width:20px;" src="./images/undo.png"/></a></p>
<hr  style="width:60%;" />
</body>

</html>
