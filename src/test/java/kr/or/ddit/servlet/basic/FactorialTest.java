package kr.or.ddit.servlet.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {

// TDD : Test Driven Development
// BDD : Behavior Driven Development	
	
	/*
	@Test : 테스트 메소드에 붙이는 어노테이션
		  해당 어노테이션을 붙이지 않으면 테스트 메소드로 인식되지 않음(테스트 대상에서 제외)
		  제한사항이 있다! 
			 1. 메소드 시그니처가 정해진대로 구성해야함
				접근제어자 : public
				반환타입 : void
				인자 : 없음
		  테스트 메소드 통과조건! 
			 1. 테스트 메소드를 실행하는 과정에서 예외가 없이 끝까지 실행된 경우 
			 2. assert 구문이 있을 경우 assert구문이 전부 통과 했을때(참으로 인정 되었을때)
	
	 @Before : 초기화 메소드에 붙이는 어노테이션
	 		   @Test  어노테이션이 붙은 테스트 메소드를 호출하기전에 먼저 실행됨
	 		   @Before ==> @Test (test)	
	 		   @Before ==> @Test (test2)	
	 		   @Before ==> @Test (test3)	
	 		   
	 @After : @Test 메소드 실행 이후에 실행된 메소드에 붙이는 어노테이션
	 		   자원 해제를 주로 담당
	 		   (비포 보단 사용도가 떨어짐)
	 		   
 	 @BeforeClass, @AfterClass
 	 	   클래스 단위로 최초 1회씩 호출되는 메소드(잘안쓰임)
 	 	   @BeforeClass
 	 	   	   @Before ==> @Test (test)	 ==> @After
	 		   @Before ==> @Test (test2) ==> @After	
	 		   @Before ==> @Test (test3) ==> @After
	 	   @AfterClass
	 	   
	 	   초기화를 딱 한번만 하고싶을때 쓰는 방법
	 	   *제한사항 : static 메소드로 선언을 해야함
	 	   			==> 해당 메소드에서 사용하는 필도는 static필드여야함
	 	   					(사용빈도가 떨어지는 원인) 		   
	*/
	
	private static final Logger logger = LoggerFactory.getLogger(FactorialTest.class);
	
	private Factorial factorial;
	
	@Before
	public void setup() {
		logger.debug("setup()");
		factorial = new Factorial();
		
	}
	
	
	
	@Test
	public void test() {
		logger.debug("test()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술
		// @Before가 test보다 항상 먼저 실행되서 안써줘도 에러안남  
		/***When***/ //테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(5);

		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증
		assertEquals(120, result);
		
	}
	
	/*메인메소드가 없어도 실행되는 이유는 이클립스에 이미 실행할수있는 모듈이 탑재되어있기때문에
	 * 실행하는게 별도로 있어서 메인메소드 실행이아님*/

	
	@Test
	public void test2() {
		logger.debug("test2()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술

		/***When***/ //테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(0);

		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증
		assertEquals(1, result);
		
	}
	

	@Test
	public void test3() {
		logger.debug("test3()");
		/***Given***/ //현재 테스트 환경에서 주어진 조건을 기술

		/***When***/ //테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(3);

		/***Then***/ //코드를 실행한 결과와 예상한 값이 일치하는지 검증
		assertEquals(6, result);
		
	}
	
}
