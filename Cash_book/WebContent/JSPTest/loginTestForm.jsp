<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginTest</title>
	<h1>컨트롤러와 login Form이 연결되는지 테스트하는 페이지입니다.</h1>
	<p>이 화면이 나오면 성공한 것입니다..</p> <br>
	
	<p>아래 로그인 폼을 이용해 로그인 테스트를 해주세요</p> <br>
	
	<article>
	<h1>Login</h1>
	<form method="post" action="CashBook?command=login">
	<fieldset>
		<legend></legend>
		<label>Password</label><input name="pw" type="password"><br>
		<label>Phone Number</label><input name="phone" type="text" value=""><br>
	</fieldset>
	<div class="clear"></div>
	<div id="buttons">
		<input type="submit" value="login" class="submit">
		<!-- 
		<input type="button"value="join" class="cancel" 
			onclick="location='bookShop?command=contract'" >
		<input type="button" value="search ID/PW" class="submit"
			onclick="location='bookShop?command=find_id_form'" >
			-->
	</div>
	</form>
</article>

</head>
<body>

</body>
</html>