<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="./header.jsp" %>
		
		
		<form  id="input_form" action="CashBook?command=input_form" method="get" name="formm">
		<select id="income_outcome" name="select">
    		<option value="income">수입</option>
    		<option value="outcome">지출</option>
    	</select>
		<tr>
			<td>날짜 </td>
			<td><input type="text" name="date" placeholder="날짜 입력바람" size="10"></td>

			<td>항목명 </td>
			<td><input type="text" name="name" placeholder="항목 입력바람"></td>

			<td>금 액 </td>
			<td><input type="text" name="amount" placeholder="금액 입력바람" size="10"></td>
			<td>비 고 </td>
			<td><input type="text" name="memo" placeholder="비고 입력바람"></td>
			
			<td><input type="button" value="insert" id="submit"></td>
			<td><input type="reset" value="cancel" id="cancel"></td>
		</tr>
		</form>
		
		<br>
		<br>
		<table border="1" id="income_table">
		<h2>수입</h2>
		<tr>
			<td>날짜</td>
			<td>항목명</td>
			<td>금액</td>
			<td>비고</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	<table border="1" id="outcome_table">
		<h2>지출</h2>
		<tr>
			<td>날짜</td>
			<td>항목명</td>
			<td>금액</td>
			<td>비고</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>



   
<%@ include file="./footer.jsp" %>