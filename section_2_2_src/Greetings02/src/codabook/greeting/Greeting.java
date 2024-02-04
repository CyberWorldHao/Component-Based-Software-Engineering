package codabook.greeting;

public class Greeting {
	
	public static void main(String[] args) {
		
		System.out.println("Hello, What is your name?");
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Greetings, " + name + "!");
		scanner.close();
	}
	
}

