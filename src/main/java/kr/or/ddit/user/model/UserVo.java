package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	
	
	private String userid;
	private String usernm;
	private String pass;
	private Date reg_dt; //java.util.Date; 이거해야지 sql거 하면 안돼
	private String alias;

	//getter, setter, toString
	//이 3개는 기본적으로 만들어놔야지 나중에 작업하기 수월하지


	// 대다수의 FRAMEWORK는 기본생성자를 필요로 한다.
	public UserVo() {}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUserrm(String usernm) {
		this.usernm = usernm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
	
	public String getReg_dt_fmt() {		
		//reg_dt 필드가 null이면 " "문자열 반환
		//reg_dt 필드가 null이 아니면 SimpleDateFormat을 생성하여 yyyy.MM.dd 포맷의 문자열로 변환하여 리턴
		if (this.reg_dt == null) {
			return "";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			return sdf.format(this.reg_dt);
		}
	}
	
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	
	
}
