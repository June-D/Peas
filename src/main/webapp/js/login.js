/**
 * 登陆页面用的JS脚本
 */
// 提交表单
function tosubmit() {
	var myform = document.getElementById("myForm");
	myform.submit();
}
//提交忘记密码表单
function toCPsubmit() {
	var  Regex=/^(?:\w+\.?)*\w+@(?:\w+\.)*\w+$/;
	var inputU=document.getElementById("inputusername").value;
	var inputM=document.getElementById("inputmail").value;
	if(inputU==""||inputU==null){
		document.getElementById("Umessage").style.display="";
		document.getElementById("Mmessage").style.display="none";
		document.getElementById("Cmessage").style.display="none";
		document.getElementById("inputusername").focus();
		return false;
	}
	if(inputM==""||inputM==null){
		document.getElementById("Umessage").style.display="none";
		document.getElementById("Mmessage").style.display="";
		document.getElementById("Cmessage").style.display="none";
		document.getElementById("inputmail").focus();
		return false;
	}
	if(inputM!=""&&inputM!=null){
		document.getElementById("Umessage").style.display="none";
		document.getElementById("Mmessage").style.display="none";
		if(Regex.test(inputM)){
			document.getElementById("Cmessage").style.display="none";
			var myform = document.getElementById("chpForm");
			myform.submit();
		}
		else{
			document.getElementById("Cmessage").style.display="";
			document.getElementById("inputmail").focus();
			return false;
		}
		
		
	}
}
// 监听键盘回车键
function keydown() { // 网页内按下回车触发
	if (event.keyCode == 13) {
		tosubmit();
	}
}
//获取Cookie
function getCookie(c_name)
{
if (document.cookie.length>0)
  {
  		c_start=document.cookie.indexOf(c_name + "=");
  		if (c_start!=-1)
  	    { 
  	    c_start=c_start + c_name.length+1;
  	    c_end=document.cookie.indexOf(";",c_start);
  	    if (c_end==-1) c_end=document.cookie.length;
  	    return unescape(document.cookie.substring(c_start,c_end));
  	    } 
  }
return null;
}
//截取字符串
function getsubStr(s_name){
	document.getElementById('Umessage').style.display="none";
	document.getElementById('Mmessage').style.display="none";
	document.getElementById('Cmessage').style.display="none";
	var str=getCookie(s_name);
	document.getElementById('userName').value=str.split('-')[0];
	document.getElementById('password').value=str.split('-')[1];
	
}