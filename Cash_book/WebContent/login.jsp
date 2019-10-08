<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
	<h1>Login</h1>
	<form method="post" action="CashBook?command=login">
	<fieldset>
		<legend></legend>
		<label>Phone Number</label>
		<input name="phone" type="text"><br> 
		<label>Password</label>
		<input name="pw" type="password"><br>
	</fieldset>
	<div class="clear"></div>
	<div id="buttons">
		<input type="submit" value="login" class="submit">
		<input type="button"value="join" class="cancel" 
			onclick="location='CashBook?command=contract'" >
	</div>
	</form>
</article>

<%@ include file="./footer.jsp" %>