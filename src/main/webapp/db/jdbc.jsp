<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// DB작업에 필요한 객체변수 선언
	//Statement 이거롤 할거고
	//select문일 경우에는 select한 결과가 ResultSet객체에 저장되어 반환 - 이거할거
	Connection conn = null; 
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB연결 ==> Connection객체 생성
		//지금 궁금한건 커넥션 얻어올때 얼마나 시간이 걸리는지 궁금해서 하는거
		
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<30; i++){
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", //1521:xe 이렇게 써도됨	
					"yez",
					"java");
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		out.print("duration : " + (endTime-startTime)); 
		
		
		
	} catch (SQLException e) {
//		throw new RuntimeException; 마이바티스에선 이걸 쓰기때문에 트라이캐치안해도됨		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		// 6. 사용했던 자원 반납하기
		if(rs!=null) try {rs.close();}catch(SQLException e) {}
		if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
		if(conn!=null) try {conn.close();}catch(SQLException e) {}
	}
	%>
</body>
</html>