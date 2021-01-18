<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		<label for="start">START</label>
		<input type="text" name="start" id="start">

		<label for="end">END</label>
		<input type="text" name="end" id="end">
		
		<button type="submit">CLICK</button>
	</form>
</body>
</html>