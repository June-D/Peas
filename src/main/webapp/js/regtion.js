/**
 * 注册页面的js脚本。
 */
// 提交表单
function tosubmit() {
	var myform = document.getElementById("regtionForm");
	myform.submit();
}
// 刷新验证码图片
function refresh(obj) {
	obj.src = "validateCode?" + Math.random();
}
//监听键盘回车键
function keydown() { // 网页内按下回车触发
	if (event.keyCode == 13) {
		tosubmit();
	}
}