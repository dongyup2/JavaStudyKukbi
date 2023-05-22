package j11_클래스_접근지정;

public class User_J11 {
	private String username;
	private String password;
	private String name;
	private String eamil;
	
	public User_J11() {
		
	}
	
	public User_J11(String username, String password, String name, String eamil) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.eamil = eamil;
	}


	//getter, setter 
	public void setUsername(String username) { //setter 전달을 해주는 것이다. 값을 넣는다
		this.username = username;
	}
	
	public String getUsername() {//getter 
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	
}
