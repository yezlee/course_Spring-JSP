package kr.or.ddit.servlet.scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/jsp/sumCalculation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int start = Integer.parseInt(request.getParameter("start")) ;
		int end = Integer.parseInt(request.getParameter("end"));
		
		logger.debug("basicServlet.doGet() userid parameter : {} {} ", request.getParameter("start"), request.getParameter("end") );
		//프로그램이 내가 원하는대로 작동 하고 있나 확인하는 용도로 logger를 쓰는데, 여기서는 파라미터값을 갖고와봐라 라고 한거
		//==> 내가 start값으로 넣은거랑 end값으로 넣은게 콘솔창에 잘 출력되나 확인하면됨
		
		
		int sum=0;
		
		for(int i = start; i <= end; i++) {
			sum += i ;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		logger.debug(String.valueOf(sum));
		// logger.debug(); 이렇게 쓰고 안에 디버깅하고싶은거 쓰면 된다. 근데 문자열 결합을 피하는게 좋은 방법.

		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
	}
}
