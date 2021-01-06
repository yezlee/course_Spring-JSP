<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(1==1){
			throw new RuntimeException();
		}
	/* if(1==1){  이걸 해준건 눈속임이야 . 예외처리 아래는 코드가 실행이 안됨*/
	%>
</body>
</html>