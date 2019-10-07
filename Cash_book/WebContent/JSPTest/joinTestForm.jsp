<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join_form입니다.</title>
<h1>Join_form입니다.</h1>
	<article>
	<h1>Login</h1>
	<form method="post" action="CashBook?command=join">
	<fieldset>
		<legend></legend>
		<label>Phone Number</label><input name="phone" type="text"><br>
		<label>Password</label><input name="pw" type="password"><br>
		<label>Name</label><input name="name" type="text"><br>
	</fieldset>
	<div id="buttons">
		<input type="submit" value="join" class="submit">
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