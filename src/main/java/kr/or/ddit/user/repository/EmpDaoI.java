package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public interface EmpDaoI {
	List<EmpVo> selectAllEmp();
	
}
