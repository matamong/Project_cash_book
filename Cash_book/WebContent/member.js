function go_save(){
	if(document.formm.phone.value==""){
		alert("전화번호를 입력하세요.");
		document.formm.phone.focus();
		
	}else if(document.formm.phone.value!=document.formm.rephone.value){
		alert("중복전화번호를 클릭하세요.");
		document.formm.phone.focus();
	
	}else if(document.formm.pw.value==""){
		alert("비밀번호를 입력하세요.");
		document.formm.pw.focus();
	
	}else if(document.formm.pw.value!=document.formm.pwCheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.formm.pwd.focus();
	
	}else if(document.formm.name.value==""){
		alert("이름 입력하세요.");
		document.formm.name.focus();
	
	}else{
		document.formm.action="CashBook?command=join";
		document.formm.submit();
	
	}
//	return true;
}

function phonenumbercheck(){
	if(document.formm.phone.value==""){
		alert("전화번호를 입력하세요.");
		document.formm.phone.focus();
		return;
	}
	
	var url="CashBook?command=phone_check_form&phone="+ document.formm.phone.value;
	window.open(url, "_blank_1","toolbar=no,menubar=no,scrollbars=yes,resizable=no,width=500,height=300");
}


	










