package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {
	
	//테스트 메소드 명명 규칙 : 테스트할 메소드 + "Test"
	@Test
	public void getCookieValueTest() {
		/***Given***/
		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "rememberme";

		/***When***/
		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);
		
		/***Then***/
		assertEquals("Y", cookieValue);

	}

	
	@Test
	public void getCookieValueTest2() {
		/***Given***/
		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "userid";

		/***When***/
		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);
		
		/***Then***/
		assertEquals("brown", cookieValue);

	}
	
	
	@Test
	public void getCookieValueTest3() {
		/***Given***/
		String cookieStr = "userid=brown; rememberme=Y; test=testcookie";
		String cookieName = "not";

		/***When***/
		String cookieValue = CookieUtil.getCookieValue(cookieStr, cookieName);
		
		/***Then***/
		assertEquals("", cookieValue);

	}
}


	