package j12_상속_다형성.factory;

import j12_상속_다형성.추상.Animal;

public class FactoryService {
	private Animal animal;
	
	public FactoryService(Animal animal) {
		this.animal = animal;
	}
	
}
