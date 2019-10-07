<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>indexTest</title>
	<h1>컨트롤러와 main JSP가 연결되는지 테스트하는 페이지입니다.</h1>
	<br><br>
	 <h2>이하 session scope test</h2> <br>
	 session에 저장된 로그인 회원 <br>
phone : ${sessionScope.phone} <br>
name : ${sessionScope.name }<br>
</head>
<body>

</body>
</html>