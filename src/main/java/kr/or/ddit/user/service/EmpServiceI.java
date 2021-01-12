package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;

public interface EmpServiceI {
	List<EmpVo> selectAllEmp();
	
}
