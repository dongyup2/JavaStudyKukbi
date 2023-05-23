package task;
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
    
    public void fetch() {
        System.out.println("Fetch!");
    }
}

//Animal animal = new Dog(); // 업캐스팅
//Dog dog = (Dog) animal; // 다운캐스팅
//dog.makeSound(); // "Bark" 출력
//dog.fetch(); // "Fetch!" 출력