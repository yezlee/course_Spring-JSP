<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
$(function(){
	$("select").on("change", function(){
		$("form").submit();
	})	
	
//	$("select").val(${param.lang})) ==> $("select").val(en) 이렇게 되니까 아래방법으로 써야해. en은 문자열이지 변수명이 아니잖아 
	$("select").val("${param.lang}") /* ==> $("select").val("${param.lang}"))  */
	
})
</script>


</head>
<body>

param :[ ${param.lang} ]
<!-- 인풋속성이 있어야해. name="lang" 옵션에는 밸류지.-->
<form action="/jstl/selectLang.jsp">
	<select name="lang">
		<option value="ko">한국어</option>
		<option value="en">ENGLISH</option>
		<option value="ja">日本語</option>
		<option value="etc">기타</option>
	</select>
<%--
 	<select name="lang">
		<option value="ko" <c:if test="${param.lang == 'ko'}"> selected </c:if> >한국어</option>
		<option value="en" <c:if test="${param.lang == 'en'}"> selected </c:if> >ENGLISH</option>
		<option value="ja" <c:if test="${param.lang == 'ja'}"> selected </c:if> >日本語</option>
		<option value="etc" <c:if test="${param.lang == 'etc'}"> selected </c:if> >기타</option>
	</select>
--%>
	<!-- <input type="submit" value="전송"/> 위에 스크립트로 이벤트 만들어서 체인지 할때마다 폼 서브밋해라 라고했으니까 이제 이 전송버튼 없어도 됨-->   



</form>
<%-- 
	select box로 설정한 언어로 GRETTING 이랑 LANG 값을 표현
	select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정
--%>
<fmt:setLocale value="${param.lang}"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING"> 
		<fmt:param value="YESEUL"></fmt:param> <br>
	</fmt:message>
</fmt:bundle>

</body>
</html>