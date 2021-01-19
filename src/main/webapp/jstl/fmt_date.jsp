<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	날짜(java.util.Date) 객체를 생성하야 속성이름 data로 pageContext에 저장
--%>
	
	<c:set var="price" value="100000" />
	<c:set var="date" value="<%=new Date() %>" />
	<c:set var="dateStr" value="2021-01-19"/>
	
	date : ${date} <br>
	
<%-- 	 <fmt:formatNumber value="${price}" type="currency" /> <br> --%>
	
	date fmt : <fmt:formatDate value="${date}" /> <br>
	date fmt : <fmt:formatDate value="${date}" type="date" dateStyle="full"/> <br>
	date fmt : <fmt:formatDate value="${date}" type="date" dateStyle="medium"/> <br>
	date fmt : <fmt:formatDate value="${date}" type="date" dateStyle="short"/> <br>
	date fmt : <fmt:formatDate value="${date}" type="time"/> <br>
	date fmt : <fmt:formatDate value="${date}" type="both"/> <br>
	
	date fmt(Custom Pattern) : <fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/> <br>
	
	parse dateString : <fmt:parseDate value="${dateStr}" pattern="yyyy-MM-dd"/>
	
</body>
</html>