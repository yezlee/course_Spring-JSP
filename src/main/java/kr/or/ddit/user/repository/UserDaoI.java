package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {
	
	//전체 사용자 정보 조회
	/*
	 	SELECT *
	 	FROM users;
	*/
	
	//반환타입 메소드명(); 인자는 없고. 셀렉문이니까.
	List<UserVo> selectAllUsers();

	//userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);

	List<UserVo> selectPagingUser(PageVo vo);
	
	
	//페이징처리를 하기 위해서는 전체 사용수 조회하는 메소드가 또 필요하당
	//사용자 전체 수 조회
	int selectAllUserCnt();
	
	//사용자 정보 수정
	int modifyUser(UserVo userVo);
//	int modifyUser(String usernm, ....); 이런식으로 하면 변경이 있을때마다 계속 수정을 해줘야해. 안정적이지 않아.
	
	
	//사용자등록
	int insertUser(UserVo userVo);

	//사용자삭제
	int deleteUser(String userid);
	
	
}
