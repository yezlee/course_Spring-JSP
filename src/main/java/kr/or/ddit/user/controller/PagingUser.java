package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//left.jsp : /pagingUser?page=1&pageSize=5
		// ==> 		 /pagingUser
		
		//doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을때
		//page는 1로, pageSize는 5로 생각을 코드로 작성
		//파라미터가 존재하면 해당 파라미터를 이용
		
		//삼항연산자
		//int page = Integer.parseInt(request.getParameter("page"));
		//위에거를 삼항연산자로 바꿔주는거야
		
		
//		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
//		int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
		
		String pageParam = request.getParameter("page");
		String pageSizeParam = request.getParameter("pageSize");
		
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pageSize = pageSizeParam == null ? 5 : Integer.parseInt(pageSizeParam);
		
		
		
		
		
		/*
		 * request 파라미터 관련 객체
		 * (set파라미터는 없다!)
		 * 
		 * getParameter
		 * 
		 * 파라미터는 내부적으로 맵 객체에서 관리가 된다.
		 * 
		 * getOrDefault - 내가 찾고자 하는게 널일때 쓰는 메소드
		 * 
		 * 
		 * request.getParameter("page") 이거를 찾는데 값이 없을수도 있는거지 그럴땐 널이 나와
		 * 
		 * 페이지라는 파라미터가 존재하지 않을수있다를 가정하고 짜야돼
		 * int page = request.getParameter("page") 
		 * 단순히 이렇게만 하면 안되는거지
		 * 왜냐 파라미터가(페이지가) 없을수도있으니까
		 */
		
		
		
		
		
		
		
		
		
		/*
		그럼 이제 이게 필요없지
		if(request.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if(request.getParameter("pageSize") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("pageSize"));
		}
		*/
		
		//refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작 방식을 유지한채로 변경하는 기법  
		
		
		UserServiceI service = new UserService();
		PageVo vo = new PageVo(page,pageSize);
		
		Map<String, Object> map = service.selectPagingUser(vo); 
		
		List<UserVo> userList = (List<UserVo>)map.get("userList");
								
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double) userCnt / pageSize);
				
		request.setAttribute("userList", userList);
		request.setAttribute("pagination", pagination);
		
		//req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
		request.getRequestDispatcher("user/pagingUser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
