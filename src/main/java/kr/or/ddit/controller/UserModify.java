package kr.or.ddit.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/userModify")
public class UserModify extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
	
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		UserVo user = userService.selectUser(userid);
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터를 읽기전에 해줘야함. 그래서 doxxx 최상단에 해야지
		//servlet의 doPost 메소드 마다 실행 필요 ==> 나중에 필터라는 개념을 배울건데
		//Filter - 객체임. 여기에 코드를 한번만 입력하면 쓸수있음
		
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("userNm");
		String pass = req.getParameter("pass");
		String reg_dt_string = req.getParameter("reg_dt");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
				
		try {
			reg_dt = sdf.parse(reg_dt_string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String alias = req.getParameter("userAlias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		
		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode);
		
		int modifyUserCnt = userService.modifyUser(userVo);
		
		if(modifyUserCnt==1) {
			/*
			  req.getRequestDispatcher("/userModify").forward(req, resp);
			  이렇게는 불가능해
			  그래서 그냥 doget을 호출하면 되지(얘를 else로 보내버림...흠???)
			  이렇게 하거나 리다이렉트로 보냄 됨 
			*/
			resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
			
		}else {
			doGet(req,resp);
			
		}
		
	}
}
