<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
		<% for(int j = 1; j <=9; j++) { %>

			<tr>
				<% for(int i = 2; i <= 9; i++) {  %>
					<td> <%= i %>   *  <%=j %>  =   <%= i*j %> </td>
				<% } %>
			
		<% } %>
	</table>
	
</body>
</html>