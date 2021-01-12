<%@page import="kr.or.ddit.user.model.EmpVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="<%=request.getContextPath()%>/main.jsp">Main<span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/allUser">전체사용자</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/allEmp">직원</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">직원</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사원번호</th>
									<th>이름</th>
									<th>직업</th>
									<th>매니저번호</th>
									<th>입사날짜</th>
									<th>샐러리</th>
									<th>성과급</th>
									<th>부서넘버</th>
								</tr>
								<% 
									List<EmpVo> List = (List<EmpVo>)request.getAttribute("List");
									for(int i=0; i< List.size(); i++ ){
								%>
									<tr>
										<td><%=List.get(i).getEmpno() %></td>
										<td><%=List.get(i).getEname() %></td>
										<td><%=List.get(i).getJob() %></td>
										<td><%=List.get(i).getMgr() %></td>
										<td><%=List.get(i).getHiredate() %></td>
										<td><%=List.get(i).getSal() %></td>
										<td><%=List.get(i).getComm() %></td>
										<td><%=List.get(i).getDeptno() %></td>
									</tr>
								<%																		
									}
								%>
							</table>
						</div>

						<a class="btn btn-default pull-right">글쓰기</a>

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
