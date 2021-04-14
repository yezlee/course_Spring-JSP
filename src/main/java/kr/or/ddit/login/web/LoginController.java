package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;


// web.xml에 설정하는 servlet, servlet-mapping을 어노테이션을 통해 설정하는 방법
@WebServlet("/loginController")
public class LoginController extends HttpServlet{
	
	//요청 메소드와 관련없이 서블릿이 동작하게 하려면?
	//사용자가 get으로 보내든, post로 보내든 상관없이 하려면
	// ==> service로!!!!(근데 일반적이진 않아)
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UserServiceI userService = new UserService();
	
	//웹브라우저 : localhost/login.jsp ==> 이건 model1 / 모델2는 서블릿으로 요청하는거
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일이름을 사용자가 알기위해서 request객체를 사용한다
		//req.getHeaderNames();
		
		
		//쿠키정보확인
		//클라이언트가 서버로 요청을 보낼시 브라우저에 의해 같이 전송된 쿠키정보확인
		//이게 지금 서버에서 쿠키를 저장한거. 클라이언트쪽에서 아이디 저장하고 하는걸(조작) 서버쪽에서도 똑같이 할 수 있다.
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			logger.debug("cookie.getName() : {} / cookie.getValue() : {} ", cookie.getName(), cookie.getValue());
			
			if(cookie.getName().equals("userid")) {
				Cookie newServerCookie = new Cookie("newServerCookie", "testValue");
				resp.addCookie(newServerCookie);
			}
		}
		
		
		// 사용자가 userid, pass 파라미터를 전송했다고 가정하고 개발을 하는거야
		
		// 하나의 파라미터 확인
		logger.debug("하나의 파라미터 확인");
		logger.debug("req.getParameter(\"userid\") : {}", req.getParameter("userid"));
		logger.debug("req.getParameter(\"pass\") : {}", req.getParameter("pass"));
		
		//복수개의 값을 갖는 파라미터 확인
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("req.getParameterValues(\"userid\") : ");
		
		for(String userid : req.getParameterValues("userid")) {
			logger.debug(userid);
		}
		
		//요청에 담긴 파라미터 이름을 확인
		logger.debug("요청에 담긴 파라미터 이름을 확인");		
		logger.debug("req.getParameterNames() : "/* , req.getParameterNames() */);
		
		Enumeration<String> enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement());
		}
		
		//요청에 담긴 파라미터를 관리하는 맵객체 확인
		logger.debug("요청에 담긴 파라미터를 관리하는 맵객체 확인");
		logger.debug("req.gerParameterMap()" /* (Object)req.getParameterMap()*/);
		Map<String, String[]> map = req.getParameterMap();
		
		Set<String> keys = map.keySet();
 		/*키는 중복이 안되는 SET*/
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			logger.debug("{}", map.get(it.next()));
		}


		//1231
		//로그인 성공시 main.jsp로 이동
		//로그인 프로세스
		//db의 저장된 사용자 정보와 일치하는지 검증해야하나, db연동이 아직 준비되지 않은 관계로 
		//userid가 brown일때 비밀번호가 brownpass 인 경우에 한해 로그인이 성공되었다고 판단
		//그외 경우는 로그인 실패로 간주
		
		//로그인 성공시 : main.jsp로 forward
		// forward : 요청을 처리할 다른 jsp, servlet에게 위임
		// 			 서버안에서 이루어지는 작업으로 클라이언트 입장에서는 누가 응답을 생성했는지 알 수 없다.
		// 			 request.getRequestDispatcher(url)를 이용하여 
		//			 requestDispatcher객체를 얻어 forward(request, response)를 실행
		//			 *** 같은 웹 어플리케이션안에서 일어나는 일이므로 contextPath를 지정하지 않는다.
		//			 (이미 해당 어플내에서 일어나기때문에 contextPath가 필요가 없음)
		
		//로그인 실패시 : login.jsp로 redirect(문법적으로 배우기 위해 이렇게 하는것임. 올바른 상황에 대해서는 추후에 다시 할것임)
		// redirect : 클라이언트에게 정해진 주소로 재요청 할 것을 지시
		//			  redirect 응답을 받은 클라이언트는 재요청 주소로 서버에게 요청한다.
		//			  원 요청 + 재 요청 : 요청이 총 2번 필요
		//			  response.sendRedirect("클라이언트가 새롭게 요청할 주소");
		//			  "클라이언트가 새롭게 요청할 주소" ==> 클라이언트가 사용하는 웹브라우저 주소줄에 표시
		//			  *** contextPath가 있을 경우 지정을 해야함
		
		
		/*
		 
		 1. userid, pass 파라미터를 문자열 변수에 저장
		 2. userid, pass 값이 지정한 값과 일치하는지 비교
		 3. 2번 비교사항이 true일때 webapp/main.jsp로 forward (main.jsp는 생성)
		 4. 2번 비교사항이 false일때 webapp/login.jsp로 redirect
 
		 */
		
		
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		UserVo user = userService.selectUser(userid);
		
		
		//로그인성공 ==> service를 통해 데이터베이스에 저장된 값과 일치할 때
		// session에 데이터베이스에서 조회한 사용자 정보(userVo)를 저장
		if(user != null && pass.equals(user.getPass())) {
			HttpSession session = req.getSession();
			session.setAttribute("S_USER", user);
		    RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
		    rd.forward(req, resp);
		}
		//실패하면 널이 들어감. 그래서 널이 아닐때
		
		//로그인실패
		else {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}
}
