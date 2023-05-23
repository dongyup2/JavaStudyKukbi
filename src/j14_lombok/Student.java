package j14_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor	 //기본생성자
@AllArgsConstructor	 //전체생성자
//@Setter				 //세터
//@Getter 			 //게터
//@EqualsAndHashCode	
//@ToString
@Data //data 하나로 위의 기능을 다사용가능
public class Student {
	private int studentCode;
	private String Name;
	private int studentYear;
	private int age;
	
}
