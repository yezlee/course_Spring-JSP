package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<style>");
		pw.println("			table{width : 100%; text-align : center; border-collapse: collapse;}");
		pw.println("			td{padding : 10px 0;}");
		pw.println("		</style>");
		pw.println("		<title>Times Tables Servlet</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table border='1'>");

		
		for(int j = 1; j <=9; j++) {

			pw.println("			<tr>");
			for(int i = 2; i <= 9; i++) {
				pw.println("<td>" + i + " * " + j +" = " + i*j + "</td>");
			}
			
		}
		
		/*
		
		이거를 반복하면 된다
		
		pw.println("			<tr>");
		for(int i = 2; i <= 9; i++) {
			pw.println("<td>" + i + " * 1 =" + i*1 + "</td>");
		}	
		
		pw.println("			<tr>");
		for(int i = 2; i <= 9; i++) {
			pw.println("<td>" + i + " * 2 =" + i*2 + "</td>");
		}
		
		
		*/
		
//		pw.println("				<td>2 * 1 = 2</td>");
//		pw.println("				<td>3 * 1 = 3</td>");
//		pw.println("				<td>4 * 1 = 4</td>");
		
		
		pw.println("			</tr>");
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
		
		
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				
			}
		}
		
		
		
	}
	
	
	
}
