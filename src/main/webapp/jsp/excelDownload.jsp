<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Contend-Disposition header :  파일 다운로드, 업로드 시 사용하는 파일과 관련된 헤더
	response.setHeader("Content-Disposition", "attachment; filename=excel.xls");	
%>    
<!DOCTYPE html>
<!-- contentType 이게 컨텐트의 헤더 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>userId</th>
			<th>이름</th>
		</tr>
		<tr>
			<td>brown</td>
			<td>브라운</td>
		</tr>
		<tr>
			<td>sally</td>
			<td>샐리</td>
		</tr>
		<tr>
			<td>connie</td>
			<td>코니</td>
		</tr>
	</table>
</body>
</html>