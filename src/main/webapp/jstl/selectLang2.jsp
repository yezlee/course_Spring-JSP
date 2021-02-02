<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
$(function(){
	
})
</script>

</head>
<body>
<form id="frm" action="${cp}/changeLang" method=""> 
	<select>
		<option>한국어</option>
		<option>ENGLISH</option>
		<option>日本語</option>
		<option>기타</option>
	</select>
</form>
<%-- 
	select box로 설정한 언어로 GRETTING 이랑 LANG 값을 표현
	select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정
--%>
<fmt:setLocale value="${lang}" var="lang"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING"> 
		<fmt:param value="YESEUL"></fmt:param> <br>
	</fmt:message>
</fmt:bundle>

</body>
</html>