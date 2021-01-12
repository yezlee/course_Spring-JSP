package kr.or.ddit.etc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaginationTest {

	@Test
	public void paginationTest() {
		/***Given***/
		int userTotCnt = 16;
		int pageSize = 5;
		
		/***When***/
		int pagination = (int)Math.ceil((double)userTotCnt/pageSize);
		
		/* userTotCnt/pageSize 그냥 이것만 하면 인트값나옴.  */
		
		/***Then***/
		assertEquals(4, pagination);
	}
}
