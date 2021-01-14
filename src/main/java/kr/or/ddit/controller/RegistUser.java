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

@WebServlet("/registUser")
public class RegistUser extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(RegistUser.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		logger.debug(userid);
		String usernm = req.getParameter("userNm");
		String pass = req.getParameter("pass");
		
		/*
		 * String reg_dt_string = req.getParameter("reg_dt");
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd"); Date reg_dt =
		 * null;
		 * 
		 * try { reg_dt = sdf.parse(reg_dt_string); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */
		
		String alias = req.getParameter("userAlias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		
		UserVo userVo = new UserVo(userid, usernm, pass, new Date(), alias, addr1, addr2, zipcode);
		
		int registerUserCnt=0;

		
		//try-catch로 잡아주는 이유
		//userService.insertUser(userVo); 지금 얘를 불러서 registerUserCnt 여기에 넣어주려고 했는데
		//userVo는 널값이야 그러면 널포인터가 뜨니까 exception으로 잡고 registerUserCnt=0;이걸 해줘서
		//아래로 쭉 실행될수있게끔
		try {
			registerUserCnt = userService.insertUser(userVo);
		} catch (Exception e) {
			registerUserCnt=0;
		}
		
		//얘한테 예외처리를 해줘야한다
		//아니면 서비스에 리턴값한테 해주거나
		//어딘가에서 한번은 예외처리해줘야함
		//업데이트도 예외처리 해줘야해 카운트하는거
		
		if(registerUserCnt==1) {
			resp.sendRedirect(req.getContextPath() + "/pagingUser");
		}else {
			req.setAttribute("userVo", userVo);
			req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
		}
		
		
	}
	
	
	
}
