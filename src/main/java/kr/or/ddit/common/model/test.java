package kr.or.ddit.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list);
		
		List<String> list2 = new ArrayList<>();
		
		list2.add("a");
		list2.add("b");
		list2.add("x");
		
		System.out.println(list2);
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("name", "송하섭");
		
		System.out.println(map);
		
		Map<String, String> map2 = new HashMap<String, String>();
		
		
		
	}

}
