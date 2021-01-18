<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table{width : 100%; text-align : center; border-collapse: collapse;}
	td{padding : 10px 0;}
</style>

</head>
<body>
	<table border='1'>
		<c:forEach begin="1" end="9" var="j">
			<tr>
				<c:forEach begin="2" end="9" var="i">
					<td> ${i} * ${j} = ${i*j} </td>
				</c:forEach>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>