package kr.or.ddit.cookie;

public class CookieUtil {
	
	/**  
	 * Method : getCookieValue 
	 * 작성자 : PC-15 
	 * 변경이력 :  
	 * @param cookieStr
	 * @param cookieName
	 * @return  
	 * Method 설명 :  cookieStr에서 cookieName에 해당하는 쿠키값을 조회
	 */ 
	
	//cookieStr : userid=brown; rememberme=Y; test=testcookie
	//cookieName : userid, rememberme
	//return : brown, Y
	public static String getCookieValue(String cookieStr, String cookieName) {

		//userid-brown; rememberme=Y; test=testcookie
		//이걸 split로 자르면 그건 문자열 배열이야
		
		String[] cookies = cookieStr.split("; ");
		//cookies[0] = userid=brown
		//cookies[1] = rememberme=Y
		//cookies[2] = test=testcookie

//		String result = "";
		
		for(int i = 0; i < cookies.length; i++) {
			String[] another_cookies_arr = cookies[i].split("=");
			if(another_cookies_arr[0].equals(cookieName)) {
				//객체비교는 equals로 한다!!! == 아니고!!!!
				return another_cookies_arr[1];
			}
		}
		
		//another_cookies_arr[0] = 쿠키이름
		//another_cookies_arr[1] = 쿠키값
		
		
		 return "";
	}
}
