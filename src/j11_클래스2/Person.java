package j11_클래스2;

public abstract class Person {
	private String name;
	private int age;
	
	public Person() {
		
	}	
		
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String mealTime();
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}	
	