package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUsers() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select : 리턴되는 값의 복수 유무를 판단
		//			1. single : 일반객체를 반환(UserVo) selectOne()
		//			2. multiple : List<UserVo> selectList()
		//insert, update, delete : insert, update, delete(메소드 이름과 동일하게 불러온다.)
		
		//메소드 이름과 실행할 sql id를 동일하게 맞추자. 그럼 나중에 유지보수할때 편함(다른 개발자의 가독성을 위해서)
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser"); //메소드 이름과 동일하게. 다만 namespace는 붙여줘야지. (users)
		
		//마이바티스는 conn stmt - 이런거 알아서 SqlSession 여기서 다 해줘 그래서 안써줘도 돼. 바로 사용한 자원 반환 고		
		//사용한 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();
		
		return user;
	}
	
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser", vo);
		sqlSession.close();

		return userList;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		//파라미터값 필요없음. select cnt(*) from emp; 
		
		sqlSession.close();
		return userCnt;
	}
	
	
}
