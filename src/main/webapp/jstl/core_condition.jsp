<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>if</h3>
	<c:set var="userid" value="brown" />
	
	<%-- 
		java에서
		if() ==> test속성에 검사할 조건식을 기술
		userid 속성의 값이 brown인지 체크하고 brown일 때만 화면에 userid 속성을 출력
		
		
		1. test 속성안에 조건을 기술할 때는 EL식에 포함해서 작성을 해야한다.
		
		X  ${userid} == "brown"    ======> 많이하는실수1
		X  ${userid} == 'brown'    ======> 많이하는실수2
		O  ${userid == 'brown'}    ======> 정답!!!!!!!!!!!
			
		2. test 속성안에 공백을 넣으면 정상적으로 판단되지 않음
		X  <c:if test="${userid == 'brown'} "> 		======> 또 많이하는실수1
		O  <c:if test="${userid == 'brown'}">
		
		
		이걸 스크립틀릿으로 쓴다면
		<%
		if( ((String)pageContext.getAttribute("userid")).equals("brown") ){
			out.write("userid-스크립틀릿 : " + (String)pageContext.getAttribute("userid"));
		}
		%>
		
			
	--%> 
	
	
	<%
		if( ((String)pageContext.getAttribute("userid")).equals("brown") ){
			out.write("userid-스크립틀릿 : " + (String)pageContext.getAttribute("userid"));
		}
	%>
	
	<br>
	<br>
	
	 
	<c:if test="${userid} == 'brown' ">		
		잘못된 예==> userid : ${userid} <br> 
	</c:if>
	
	
	
	<c:if test="${userid == 'brown'} ">
		잘못된 예2==> userid : ${userid} <br> 
	</c:if>		
	
	
	<c:if test="${userid == 'brown'}">
		정답 ==> userid : ${userid} <br> 
	</c:if>	
	
	
	
	
	<br>
	<br>
	<h3>choose : 일반 if, else if, else</h3>
	<c:choose>
		<c:when test="${userid=='sally'}">sally 사용자 입니다.</c:when>
		<c:when test="${userid=='moon'}">moon 사용자 입니다.</c:when>
		<c:when test="${userid=='brown'}">brown 사용자 입니다.</c:when>
		<c:when test="${userid=='cony'}">cony 사용자 입니다.</c:when>
		<c:otherwise>when절에 매칭되는 조건이 없습니다.</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
</body>
</html>