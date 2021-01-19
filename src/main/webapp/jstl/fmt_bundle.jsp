<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>KOREAN</h3>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<<fmt:message key="LANG"/>> <br>
	<fmt:message key="GREETING"> 
		<fmt:param value="YESEUL"></fmt:param> <br>
	</fmt:message>
</fmt:bundle>

<br><br>
<!-- 로케일 설정 변경 -->
<h3>ENGLISH</h3>
<fmt:setLocale value="en"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING"> 
		<fmt:param value="YESEUL"></fmt:param> <br>
	</fmt:message>
</fmt:bundle>


<br><br>
<h3>setBuldle : 번들값을 속성에 저장</h3>
<h4>message태그를 사용할 때 번들을 지정 ==> bundle 태그 없이 사용 가능</h4>

<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
<!-- 번역본에 대한 코드가 다 var에 담기는거. 출력하는게 아니고 값을 저장하는개념이다. -->

<fmt:message key="LANG" bundle="${msg}"/><br>
<fmt:message key="GREETING" bundle="${msg}"> 
	<fmt:param value="YESEUL"></fmt:param> <br>
</fmt:message>


<br>
<fmt:message key="LANG" bundle="${msg}" var="lang"/>
${lang}


</body>
</html>