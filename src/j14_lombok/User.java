package j14_lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
	
	private String email;
	private String name;
	@NonNull //null을 허용하지않음
	private String username;
	@NonNull
	private String password;
	
}
	
