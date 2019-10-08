<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
	<h1>input</h1>
	<form method="post" action="CashBook?command=input">
	<fieldset>
		<legend></legend>
		<label>지출 or 수입</label><input name="select" type="text"><br>
		<label>날짜 </label><input name="date" type="text"><br>
		<label>항목명</label><input name="name" type="text"><br>
		<label>금액</label><input name="amount" type="text"><br>
		<label>비고</label><input name="memo" type="text"><br>
	
	</fieldset>
	<div id="buttons">
		<input type="submit" value="input" class="submit">
</div>
</form>
</article>
</body>
</html>