package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {

	private UserDaoI userDao;
	
	@Before
	public void Setup() {
		
		userDao = new UserDao();
				
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser", "테스트사용자", "testUserPass", new Date(), "대덕", "대전 중구 중앙로 76", "4층", "34940","brown.png","uuid");
		
		//userDao.deleteUser("testUser"); //항상 한번만 입력이 되게끔. 이걸 @After에 해도됨
		userDao.insertUser(userVo);
		
		//신규입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제하겠다.
		userDao.deleteUser("ddit_n");
		
		
	}
	
	
	@After
	public void tearDown() {
		userDao.deleteUser("testUser"); //항상 한번만 입력이 되게끔.
	}
		
	
	//전체 사용자 조회 테스트
	@Test
	public void selectAllUserTest() {
		/***Given***/
//		UserDaoI userDao = new UserDao(); 이제 이게 필요없지. 위에서 테스트할때마다 새롭게 만들어주니까 
		

		/***When***/
		List<UserVo> userList = userDao.selectAllUsers();
		
		/***Then***///db안에 있는 건수를 보고선 사이즈가 같냐고 물어봐
		assertEquals(17, userList.size());
	}
	
	//사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	// public void 항상 이래야함. 규칙.
	public void selectUserTest() {
		/***Given***/
//		UserDaoI userDao = new UserDao();
		String userid = "brown";

		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}
	
	//사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/***Given***/
//		UserDaoI userDao = new UserDao();
		PageVo vo = new PageVo(2,5);
		
		/***When***/
		List<UserVo> userList = userDao.selectPagingUser(vo); 

		/***Then***/
		assertEquals(5, userList.size());
	}
	
	
	@Test
	public void selectAllUserCnt() {
		/***Given***/
//		UserDaoI userDao = new UserDao();
		

		/***When***/
		int userCnt = userDao.selectAllUserCnt();
		
		/***Then***/
		assertEquals(17, userCnt);
	}
	
	
	@Test
	public void modifyUserTest() {
		/***Given***/
//		UserDaoI userDao = new UserDao();
		
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		//UserVo userVo = new UserVo(); 이렇게만 썼다가 생성자 만들려고 아래 다시
		UserVo userVo = new UserVo("ddit", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원", "34940","brown.png","uuid");
		//여기에 8개 다 추가하기 손이 많이가니까 위에 생성자를 만들어주자
		
		
		/***When***/
		int updateCnt = userDao.modifyUser(userVo);
		

		/***Then***/
		assertEquals(1, updateCnt);
		
		//이 테스트 코드를 실행하면 
		//UserVo userVo = new UserVo("ddit", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원", "34940");
		//이게 실행되서 해당 파라미터들이 업데이트가 된거야
	}
	
	
	@Test
	public void registUserTest() {
		/***Given***/
//		UserDaoI userDao = new UserDao();
		
		UserVo userVo = new UserVo("ddit_n", "대덕인재", "dditpass", new Date(), "개발원_m", "대전시 중구 중앙로 76", "4층 대덕인재개발원", "34940","brown.png","uuid");

		/***When***/
		int insertCnt = userDao.insertUser(userVo); 

		/***Then***/
		assertEquals(1, insertCnt);
	}
	

	//삭제테스트
	@Test
	public void deleteUserTest() {
		/***Given***/
		//해당 테스트가 실행될 때는 testUser라는 사용자가 before 메소드에 의해 등록이 된 상태
		String userid = "testUser";

		/***When***/
		int deleteCnt = userDao.deleteUser(userid);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	
	
}
