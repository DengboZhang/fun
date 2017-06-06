function windowOnload(f){
	var func = window.onload;
	if(typeof(window.onload)!=="function"){
		window.onload=f;
	}
	else{
		window.onload=function(){
			func();
			f();
		}
	}
}
