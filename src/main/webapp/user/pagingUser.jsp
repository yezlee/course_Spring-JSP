<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
	List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Jsp</title>

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<%@include file="/common/common_lib.jsp" %>
<!-- <link href="bootstrap.css" rel="stylesheet"> -->
<!-- Bootstrap core CSS -->
<!-- <script src="bootstrap.js"></script>Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<script type="text/javascript">
	//문서 로딩이 완료되고 나서 실행되는 영역
	$(function(){
		$(".user").on("click", function(){
			
			//this : 클릭 이벤트가 발생한 element
			//data-속성명 ex: data-userid 에서  userid만 .data("")안에 넣음됨. 속성명은 대소문자무시하고 다 소문자로 인식
			console.log($(this).data("userid"));
			
/* 			alert.log$(this).data("userid");
			예전에 콘솔로그 없을땐 얼럿창 많이씀
*/
			
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
			
			
		});
	});
</script>

</head>

<body>

	<form id="frm" action="<%=request.getContextPath()%>/user">
		<input type="hidden" id="userid" name="userid" value=""/>
	</form>


	<%@ include file="/common/header.jsp"%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">JSP/SPRING</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/common/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
				<%
					/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); */
					if(userList!=null){
						for(int i = 0; i<userList.size(); i++){
							UserVo vo = userList.get(i);
				%>
								<tr class="user" data-userid="<%=vo.getUserid() %>">
									<td><%=vo.getUserid() %></td>
									<td><%=vo.getUsernm() %></td>
									<td><%=vo.getAlias() %></td>
									<td><%=vo.getReg_dt_fmt() %></td>


									<%--
									직접 조건문 써서 하는 방법. 하지만 이 방법은 비추. 그래서 VO에서 로직을 씀
									 
									<%if(vo.getReg_dt()!=null) {%>
										<td><%=sdf.format(vo.getReg_dt()) %></td>
									<%}else{ %>
										<td></td>
									<%} %> 
									
									--%>
								</tr>
								<%
						}
					}
				%>
							</table>
						</div>

						<a href="/user/registUser.jsp" class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							request.getAttribute("pageVo") :
							<%=((PageVo)request.getAttribute("pageVo")).getPage() %>



							<ul class="pagination">

								<!-- 
									pagination 값이 4이므로 1부터 4까지 4번 반복된다.
									전체 사용자수 : 16명
									페이지 사이즈 : 5
									전체 페이지수 : 4페이지
								 -->
								<% 
							/* int cur_page = ((PageVo)request.getAttribute("pageVo")).getPage(); */
							PageVo cur_page = (PageVo)request.getAttribute("pageVo");
							int pagenation = (Integer)request.getAttribute("pagination"); %>

								<li class="prev"><a
									href="<%=request.getContextPath()%>/pagingUser?page=1&pageSize=<%=cur_page.getPageSize()%>">«</a>
								</li>

								<%for(int i=1; i<=(int)request.getAttribute("pagination"); i++ ){%>
								<% if(i == cur_page.getPage()){%>
								<!-- 만약에 int로 받으면 그냥 i==cur.page라고 하면 되는데 -->
								<li class="active"><span><%=i%></span></li>
								<% }else{%>
								<li><a
									href="<%=request.getContextPath()%>/pagingUser?page=<%=i%>&pageSize=<%=cur_page.getPageSize()%>"><%=i%></a></li>
								<% }%>
								<% }%>

								<li class="prev"><a
									href="<%=request.getContextPath()%>/pagingUser?page=<%=pagenation%>&pageSize=<%=cur_page.getPageSize()%>">»</a>
								</li>
								<%-- 
				
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=2&pageSize=5">2</a></li>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=3&pageSize=5">3</a></li>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=4&pageSize=5">4</a></li>
									<li><a href="<%=request.getContextPath()%>/pagingUser?page=5&pageSize=5">5</a></li>
								 --%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
