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

    <title>Signin Template for Bootstrap</title>

<%--
    <title>Signin Template for Bootstrap **</title>
    제목에 **이렇게 붙이고 실행함으로써 확인할수있어. 그리고 다시 **지우면 됨
    
    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet"> 
	이 링크태그를 아래 include에 따라가면 있는 jsp파일에 넣어놓음
	그래서 주석처리    
--%>
	<%@ include file ="/common/common_lib.jsp" %>
	<!-- common_lib.jsp의 내용을 지금 기술되는 부분에 코드를 복사해서 붙여넣기  -->
	
	
	

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<%=request.getContextPath() %>/loginController" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userid" class="sr-only">userid</label>
        <input type="text" id="userid" name="userid" value="brown" class="form-control" placeholder="Enter Id" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pass" value="brownpass" class="form-control" placeholder="Enter Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
   
  </body>
</html>
