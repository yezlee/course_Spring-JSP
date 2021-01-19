<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%-- 
 	application 영역에 저장된 requestCountMap 객체를 forEach를 통해 tr 태그로 생성
 		uri 반복횟수
  --%>
  
  <table>
  	<tr>
  		<th>uri</th>
  		<th>반복횟수</th>
  	</tr>
  	
  	<c:forEach items="${requestCountMap}" var="entry">
	  	<tr>
	  		<td>${entry.key}</td>
	  		<td>${entry.value}</td>
	  	</tr>
  	</c:forEach>
  	
<%-- entry가 key를 하나씩 꺼내주는거? 향상된포문처럼   	

${requestCountMap.userid} 이렇게 불러오는거지 값을 불러올때는 --%>
  	
  </table>
</body>
</html>