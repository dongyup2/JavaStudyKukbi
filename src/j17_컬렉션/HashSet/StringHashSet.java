package j17_컬렉션.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class StringHashSet {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("java");
		set.add("java");
		set.add("java");
		set.add("java");
		set.add("python");
		set.add("python");
		set.add("python");
		set.add("python");
		set.add("1");
		set.add("2");
		
		System.out.println(set);
		// 값 조회 
		Iterator<String> ir = set.iterator();
		while(ir.hasNext()) { //while 안에선 next는 한번만
			String str = ir.next(); // str 변수에 대입 한번만 호출
			if(str.equals("java")) {
				System.out.println(str);				
			}
		}
		
	}

}
