package codabook.greeting;

import java.util.Scanner;

public class Greeting {

	public static void main(String[] args) {
		System.out.println("Hello, What is your name?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Greetings, " + name + "!");
		scanner.close();
	}

}
