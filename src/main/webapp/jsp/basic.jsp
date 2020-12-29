<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 	<%@ %> : 지시자 : jsp페이지에 대한 설정 정보 	--%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--       <% %> <!-- 스크립틀릿 : 자바코드를 작성  -->        --%>
	
	<% Date date = new Date(); %>
	Hello, World! <%= date %>  
	
	<%--       <%= %> <!-- 표현식 : 문자열 출력 -->         --%>
	
	
	
</body>
</html>


<!--
	jsp 구성요소
	1. 지시자(%@) : page에 대한 설정 정보를 말한다. - 주로 쓰는건 import밖에 없지, 그거랑 language!
	2. 스크립틀릿(%) : java 코드가 들어감 ==> JSTL이라는 애로 나중에 바꿀거야. JSTL(Java Standard Tag Library)
	3. 표현식(%=) : 문자열로 출력 ==> EL(Expression Language, 표현언어)
	4. 주석
	5. 선언부(쓸일이 없음)
		- 변수나 메소드 선언하는 부분
		- jsp는 화면 컨텐츠를 생성하는 역할(화면을 그려내는 애)
		- 근데 변수가 메소드는 로직 처리시 주로 사용 그래서 여기선 선언부를 잘 안씀
		
		
	1번이랑 4번만 주로 사용함
		
 -->