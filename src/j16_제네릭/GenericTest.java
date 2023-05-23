package j16_제네릭;

import lombok.Data;

@Data
public class GenericTest<K, V> {
	private K number;
	private V data;
	
}
