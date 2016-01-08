package interfaces;

public interface Person {
	
	//DEFAULT: insert methods with implementation
	default public void speak() {
		System.out.println("speak method of interface Person");
	}
	
	default public void show() {
		System.out.println("show ");
	}

}
