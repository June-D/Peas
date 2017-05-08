/**
 * 公共js脚本。
 */
//获取当前系统时间并格式化展示
function dateTime() {
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth();
	var day = today.getDate();
	var hour = today.getHours();
	var min = today.getMinutes();
	var second = today.getSeconds();
	month = addzero(month);
	day = addzero(day);
	hour = addzero(hour);
	min = addzero(min);
	second = addzero(second);
	//var week = today.getDay();
	// 获取星期
	var arr = new Array(6);
	arr[0] = "星期日";
	arr[1] = "星期一";
	arr[2] = "星期二";
	arr[3] = "星期三";
	arr[4] = "星期四";
	arr[5] = "星期五";
	arr[6] = "星期六";
	document.getElementById('time').innerHTML = year + "-" + month + "-" + day
			+ " " + hour + ":" + min + ":" + second + " " ;
	t = setTimeout(dateTime, 500);
}

function addzero(v) {
	if (v < 10) {
		v = "0" + v;
		return v;
	} else {
		return v;
	}
}

//判断用户代理登录
(function() {
	if(isMobile()) {
	location.replace("http:www.m.nwnd.com");
	}
	function isMobile() {
	return navigator.userAgent.match(/Mobile|iPhone|iPad|Android/i) || Math.min(screen.height,screen.width) <= 480;
	}
	})();

