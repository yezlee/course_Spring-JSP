<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	var test = " <%=application.getAttribute("application") %> "
	var test = "sally_application"
	/* 위에 두개는 같은 거임. 이게 가능한건  */
	
	<%-- 
	
	<%String a %> = test; 
	이건 안돼.
	이미 <%String a %> 이게 html로 바뀌어서 출력된거라서 에러나. 컴파일조차 안됨
	
	--%>
	/*
	클라이언트에서는 서버 사이드 변수 값을 활용할 수 있으나
	서버 사이드 변수에 클라이언트 사이드 변수 값을 대입할 수는 없다.
	*/
	
	
</script>


</head>
<body>
<!-- 속성설정이 끝나면 webapp/jsp/scopeResult.jsp로 forward
scopeResult.jsp에서는 Scope servlet에서 설정한 3개의 속성을
속성명 : 속성값 
속성명 : 속성값 
속성명 : 속성값 
속성명 : 속성값 형식으로 화면에 출력 -->

	<!-- 스코프객체.getAttribute("속성명") , 반환타입 : Object -->
	request : <%=request.getAttribute("request") %> <br>
	<!-- 반환타입이 오브젝이라 형변환을 해줘도 상관없긴하지만 실행하면 잘 나와서 스킵 -->
	session : <%=session.getAttribute("session") %> <br>
	application : <%=application.getAttribute("application") %> <br>

<!--  이거 실행은 서버에서 하는거야. jsp라고 클라이언트에서 실행하는게 아니고
	만들어진 서버에서 실행하고 여기 jsp는 그냥 위임받아서 하는거니까  
 -->



</body>
</html>