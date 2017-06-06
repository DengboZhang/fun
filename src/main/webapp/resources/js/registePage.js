function validateInfo(){
	var userName = document.getElementById("userName");
	var passWord = document.getElementById("passWord");
	var passWordCheck = document.getElementById("passWordCheck");
	var phone = document.getElementById("phone");
	var email = document.getElementById("email");
	var verificationCode = document.getElementById("verificationCode");
	var submitBtn = document.getElementById("submit");
	if(document.addEventListener){
		userName.addEventListener("input",validateUserNameInput);
		userName.addEventListener("invalid",validateUserNameInvalid);
		passWord.addEventListener("input",validatePassWordInput);
		passWord.addEventListener("invalid",validatePassWordInvalid);
		passWordCheck.addEventListener("input",validatePassWordCheckInput);
		passWordCheck.addEventListener("invalid",validatePassWordCheckInvalid);
		phone.addEventListener("input",validatePhoneInput);
		phone.addEventListener("keypress",validatePhoneInputCode);
		phone.addEventListener("invalid",validatePhoneInvalid);
		verificationCode.addEventListener("input",validateVerificationCodeInput);
		verificationCode.addEventListener("invalid",validateVerificationCodeInvalid);
		submitBtn.addEventListener("click",validatePassWordInfo);
	}
	else if(document.attachEvent){
		userName.attachEvent("oninput",validateUserNameInput);
		userName.attachEvent("oninvalid",validateUserNameInvalid);
		passWord.attachEvent("oninput",validatePassWordInput);
		passWord.attachEvent("oninvalid",validatePassWordInvalid);
		passWordCheck.attachEvent("oninput",validatePassWordCheckInput);
		passWordCheck.attachEvent("oninvalid",validatePassWordCheckInvalid);
		phone.attachEvent("oninput",validatePhoneInput);
		phone.attachEvent("onkeypress",validatePhoneInputCode);
		phone.attachEvent("oninvalid",validatePhoneInvalid);
		verificationCode.attachEvent("oninput",validateVerificationCodeInput);
		verificationCode.attachEvent("oninvalid",validateVerificationCodeInvalid);
		submitBtn.attachEvent("onclick",validatePassWordInfo);
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
	function validatePassWordCheckInput(e){
		var e = e || window.event;
		if(passWordCheck.value==""){
			passWordCheck.setCustomValidity("请输入此字段。");
		}
		else if(passWordCheck.value.length>=6){
			passWordCheck.setCustomValidity("");
		}
		else{
			passWordCheck.setCustomValidity("输入的字段必需在6到16字段之间。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePassWordCheckInvalid(e){
		var e = e || window.event;
		if(passWordCheck.value.length>0&&passWordCheck.value.length<6){
			passWordCheck.setCustomValidity("输入的字段必需在6到16字段之间。");
		}
		else if(passWord.value!==passWordCheck.value){
			passWordCheck.setCustomValidity("密码和确认密码不一致。");
		}
		else{
			passWordCheck.setCustomValidity("请输入此字段。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePhoneInput(e){
		var e = e || window.event;
		if(phone.value==""){
			phone.setCustomValidity("请输入手机号码。");
		}
		else if(phone.value.length==11){
			phone.setCustomValidity("");
		}
		else{
			phone.setCustomValidity("请输入正确的手机号。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePhoneInputCode(e){
		var e = e || window.event;
		var code = e.charCode||e.keyCode;
		if(!(code>=48&&code<=57)){
			if(e.stopPropagation)e.stopPropagation();
			else e.cancelBubble=true;
			if(e.preventDefault)e.preventDefault();
			else e.returnValue=false;
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePhoneInvalid(e){
		var e = e||window.event
		if(phone.value.length>0)
			phone.setCustomValidity("请输入正确的手机号。");
		else
			phone.setCustomValidity("请输入手机号码。");
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validateVerificationCodeInput(e){
		var e = e || window.event;
		if(verificationCode.value==""){
			verificationCode.setCustomValidity("请输入验证码。");
		}
		else if(verificationCode.value.length==4){
			verificationCode.setCustomValidity("");
		}
		else{
			verificationCode.setCustomValidity("请输入正确的验证码格式。");
		}
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validateVerificationCodeInvalid(e){
		var e = e||window.event;
		if(verificationCode.value.length>0)
			verificationCode.setCustomValidity("请输入正确的验证码格式。");
		else
			verificationCode.setCustomValidity("请输入验证码。");
		if(e.stopPropagation)e.stopPropagation();
		else e.cancelBubble=true;
	}
	function validatePassWordInfo(e){
		var e = e|| window.event;
		if(!(passWord.value===passWordCheck.value)&&userName.validity.valid&&phone.validity.valid&&email.validity.valid&&verificationCode.validity.valid){
			passWordCheck.setCustomValidity("checkInfo");
			
		}		
	}
}
windowOnload(validateInfo);
