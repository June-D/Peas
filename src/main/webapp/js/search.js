/**
 * 主页面的js脚本
 */
function select_onchange() {
	var myform = document.getElementById("langForm");
	myform.action = "langLocale";
	myform.submit();
}
function load() {
	try {
		dateTime();
		var username = document.getElementById('user').innerHTML;
		if (username != null && username != "") {

			document.getElementById('LOGR').style.display = "none";
			document.getElementById('logout').style.display = "";

		} else {
			// prompt("文本","默认值");
			document.getElementById('logout').style.display = "none";
			document.getElementById('LOGR').style.display = "";
		}
	} catch (err) {
		txt = "此页面存在一个错误。\n\n";
		txt += "错误描述: " + err.description + "\n\n";
		txt += "点击OK继续。\n\n";
		alert(txt);
	}
}
/**
 * 注销确认
 */
function makesureout(){
	var makesure=confirm("确认注销用户？");
	if(makesure){
		return true;
	}else{
		return false;
	}
}