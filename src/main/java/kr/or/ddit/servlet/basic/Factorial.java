package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
	private static final Logger logger = LoggerFactory.getLogger(Factorial.class);
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		
		int result = factorial.calculate(5);
	
		if(result == 120) {
			logger.debug("success");
		}else {
			logger.debug("fail");
		}
		
		
		int result2 = factorial.calculate2(5);
		
		if(result2 == 120) {
			logger.debug("success");
		}else {
			logger.debug("fail");
		}
		
		System.out.println(result2);
	}

	/**
	 * 
	 * Method : calculate 
	 * 작성자 : PC-15 
	 * 변경이력 :  
	 * @param n
	 * @return  
	 * Method 설명 :
	 */
	public int calculate(int n) {
		
		int num = 1;
		
		for(int i = 1; i <= n; i++) {
			num = i * num;
		}
		
		return num;
	}
	
	
	private int calculate2(int n) {
		if(n<=1)
			return 1;
		else
			return n * calculate2(--n);
	}

		
	
	
	
}
