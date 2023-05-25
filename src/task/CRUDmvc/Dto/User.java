package task.CRUDmvc.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	 private int usercode;
	 private String name;
	 private String id;
	 private String password;
	 private String email;
	 private String phone;
	 private String address;
	 private String createDate;
	 
	 public User Entity() {
		 return Entity().builder()
				 .usercode(usercode)
				 .name(name)
				 .id(id)
				 .password(password)
				 .email(email)
				 .phone(phone)
				 .address(address)
				 .createDate(createDate)
				 .build();
	 }
}
