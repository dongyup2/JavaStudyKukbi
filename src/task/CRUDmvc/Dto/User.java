package task.CRUDmvc.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	 private int usercode;
	 private String id;
	 private String pwd;
	 private String name;
	 private String email;
	 private String phone;
	 private String address;
	 private String createDate;
	 
	 public User Entity() {
		 return Entity().builder()
				 .usercode(usercode)
				 .name(name)
				 .id(id)
				 .pwd(pwd)
				 .email(email)
				 .phone(phone)
				 .address(address)
				 .createDate(createDate)
				 .build();
	 }
}
