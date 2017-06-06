function validityInfo(){
	var userName = document.getElementById("userName");
	var passWord = document.getElementById("passWord");
	if(document.addEventListener){
		userName.addEventListener("input",validateUserNameInput);
		userName.addEventListener("invalid",validateUserNameInvalid);
		passWord.addEventListener("input",validatePassWordInput);
		passWord.addEventListener("invalid",validatePassWordInvalid);
	}
	else{
		userName.attachEvent("oninput",validateUserNameInput);
		userName.attachEvent("oninvalid",validateUserNameInvalid);
		passWord.attachEvent("oninput",validatePassWordInput);
		passWord.attachEvent("oninvalid",validatePassWordInvalid);
	}
	function validateUserNameInput(e){
		var e = e || window.event;
		if(userName.value==""){
			userName.setCustomValidity("请输入此字段。");
		}
		else if(userName.value.length>=6){
			userName.setCustomValidity("");
		}
		else{
			userName.setCustomValidity("输入的字段必需在6到16字段之间不包含特殊字符。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validateUserNameInvalid(e){
		var e = e || window.event;
		if(userName.value.length>0)
			userName.setCustomValidity("输入的字段必需在6到16字段之间不包含特殊字符。");
		else
			userName.setCustomValidity("请输入此字段。");
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePassWordInput(e){
		var e = e || window.event;
		if(passWord.value==""){
			passWord.setCustomValidity("请输入此字段。");
		}
		else if(passWord.value.length>=6){
			passWord.setCustomValidity("");
		}
		else{
			passWord.setCustomValidity("输入的字段必需在6到16字段之间。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePassWordInvalid(e){
		var e = e || window.event;
		if(passWord.value.length>0)
			passWord.setCustomValidity("输入的字段必需在6到16字段之间。");
		else
			passWord.setCustomValidity("请输入此字段。");
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
}
windowOnload(validityInfo);
