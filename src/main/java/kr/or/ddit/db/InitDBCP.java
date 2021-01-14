package kr.or.ddit.db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(value="/initDBCP", loadOnStartup = 1)
public class InitDBCP extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(InitDBCP.class);
		
	@Override
	public void init() throws ServletException {
		logger.debug("InitDBCP.init()");
		
		//커넥션 풀 생성
		//application scope에 커넥션 풀 저장
		
		//dbcp.jsp에서는 application scope 저정된 커넥션풀을 사용하여 커넥션 객체를 얻고 해제하는 과정을 반복 - 시간체크
		
		
	}
}
