<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   

<article>
	<h2>Join</h2>
	<form  id="join" action="CashBook?command=join" method="post" name="formm">
	<fieldset>
		<label>Name</label>
		<input type="text" name="name"><br>
		<label>Phone</label> 
		<input  type="text" name="phone" size="11">
		<input  type="hidden" name="rephone">
		<input  type="button" value="Check phonenumber" class="dup" onclick="phonenumbercheck()"><br>
		<label>Password</label>
		<input  type="password" name="pw"><br>
		<label>Retype Password</label>
		<input  type="password" name="pwCheck"><br>
	</fieldset>	
		
	<div class="clear"></div>
	<div id="buttons">
		<input type="button" value="join" class="submit" onclick="go_save()" >
		<input type="reset" value="cancel" class="cancel">
	</div>
	</form>
</article>

<%@ include file="../footer.jsp" %>