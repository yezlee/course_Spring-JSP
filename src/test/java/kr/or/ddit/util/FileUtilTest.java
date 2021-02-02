package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilTest {

	/*
	 String contentDisposition = " form-data; name="file"; filename="brown.png" ";

	 FileUtil.getFileName(contentDisposition)을 테스트 할수 있는 테스트 코드 작성
	 ==> brown.png

	 */
	
	@Test
	public void FileUtilTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

		/***When***/
		String filename = FileUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", filename);
	

	}

	
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String fileName = "brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(fileName);

		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String fileName = "line.brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(fileName);

		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest3() {
		/***Given***/
		String fileName = "brown";

		/***When***/
		String extension = FileUtil.getFileExtension(fileName);

		/***Then***/
		assertEquals("", extension);
	}
	
}
