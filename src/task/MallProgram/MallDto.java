package task.MallProgram;

import java.util.ArrayList; 
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class MallDto {
	
	private String username; 
	private String password;
	private String name;
	private String email;
	
	public MallDtoBuilder toBuilder() {
	    return MallDto.builder()
	            .username(this.username)
	            .password(this.password)
	            .name(this.name)
	            .email(this.email);
	}
}
