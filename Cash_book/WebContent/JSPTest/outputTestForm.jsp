<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
보고싶은 지출 내역 설정하는 page(날짜선정) <br>
session에는 "loginUser"(유저정보) 저장되어있고 <br>
request에는 날짜가 저장되어있겠지 이것들은 다시 outputAction으로 보내질것이고...


<article>
	<h1>Login</h1>
	<form method="post" action="CashBook?command=output">
	<fieldset>
		<legend></legend>
		<label>지출 or 수입</label><input name="select" type="text"><br>
		<label>날짜 </label><input name="date" type="text"><br>
	</fieldset>
	<div id="buttons">
		<input type="submit" value="output" class="submit">
		<!-- 
		<input type="button"value="join" class="cancel" 
			onclick="location='bookShop?command=contract'" >
		<input type="button" value="search ID/PW" class="submit"
			onclick="location='bookShop?command=find_id_form'" >
			-->
	</div>
	</form>
</article>


</body>
</html>