<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp}/mulCalculation" method="post">
		<label for="num1">NUM1</label>
		<input type="text" name="param1" id="num2">

		<label for="num2">NUM2</label>
		<input type="text" name="param2" id="num2">
		
		<button type="submit">CLICK</button>
	</form>
</body>
</html>