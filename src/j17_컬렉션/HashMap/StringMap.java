package j17_컬렉션.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class StringMap {

	public static void main(String[] args) {
		
		HashMap<Integer, String> strMap = new HashMap<Integer, String>();
		
		HashMap<String, String> strMap2 = new HashMap<String, String>();
		
		strMap.put(10, "java1"); //순서가없고 키 중복 안된다. 인덱스가없어서 반복을 돌릴수없다.
		strMap.put(20, "java2"); // put 은 해당 맵에 추가하는것이
		strMap.put(30, "java3");
		strMap.put(40, "java4");
		
		System.out.println(strMap); 
		
		strMap2.put("a", "python");
		strMap2.put("b", "python");
		strMap2.put("c", "python");
		strMap2.put("d", "python");
		
		System.out.println(strMap2);
			
		strMap.get(10); // 해당값을 가져올때 get을 쓴다.
		
		Iterator<Integer> irKey = strMap.keySet().iterator();
		while(irKey.hasNext()) {
			System.out.println(strMap.get(irKey.next()));
		}
		strMap.entrySet().forEach(arg ->{
			System.out.println(arg);
			System.out.println(arg.getKey()); 
			System.out.println(arg.getValue()); 
		});
	
		strMap.getOrDefault(irKey, null);
	}
	

}
