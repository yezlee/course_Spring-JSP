<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%-- 개인정보를 전송하므로 url에 노출되지 않도록 request body영역에 파라미터를 전송
		==> method="POST"
	 --%>

	<form action = "<%=request.getContextPath() %>/loginController" method="POST">
		<p>user ID : <input type = "text" name = "userid" value="test"/></p>
		<p>user ID : <input type = "text" name = "userid" value="test1"/></p>
		<p>password : <input type = "password" name = "pass" value="1234"/></p>
		<p><input type = "submit" value="전송"></p>
	</form>
</body>
</html>