package j18_Json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
	public static User createUser() {
		List<String> hobby = new ArrayList<String>();//hobby 는 리스트로 생성한다
		hobby.addAll(Arrays.asList(new String[] {"축구", "농구", "야구", "골프"}));
		User user = User.builder()
				.userCode(1)
				.username(null)
				.password("1234")
				.name("이동엽")
				.email("dlehdduq22@naver.com")
				.address("부산 해운대구 반여동")
				.phone("010-7464-0339")
				.hobby(hobby) //하비에
				.build();
		return user;
	}
}
