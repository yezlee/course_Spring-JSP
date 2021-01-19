<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Jsp</title>
<%@ include file="/common/common_lib.jsp"%>
<link href="${pageContext.request.contextPath}/css/dashboard.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
</head>
<body>

	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">전체사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								
								<c:forEach items="${userList}" var="user">
									<tr>
										<td>${user.userid}</td>
										<td>${user.usernm}</td>
										<td>${user.alias}</td>
										<td>${user.reg_dt_fmt}</td>
									</tr>
								</c:forEach>
								
								
<%-- 								
								
								<% 
									for(int i=0; i<userList.size(); i++ ){
									/* for(UserVo user : (List<UserVo>)request.getAttribute("userList")){ */	
								%>
									<tr>
										<td><%=userList.get(i).getUserid() %></td>
										<td><%=userList.get(i).getUsernm() %></td>
										<td><%=userList.get(i).getAlias() %></td>
										<td><%=userList.get(i).getReg_dt_fmt() %></td>
										<!-- getReg_dt_fmt() 메소드를 만들어서 여기서 데이터 포맷을 해줌. 
										널포인터가 나오니까 널값이 나오면  ""를 반환하도록 UserVo.java에서 코드를 추가함 -->
										<td><%=sdf.format(userList.get(i).getReg_dt()) %></td>
									</tr>
								<%
																		
									}
								%>
								
--%>
								
							</table>
						</div>

						<a class="btn btn-default pull-right">글쓰기</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
