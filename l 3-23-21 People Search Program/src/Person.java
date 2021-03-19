import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
	static Scanner sc;
	private String name;
	private int age;

	public Person(String n, int a){
		setName(n);
		setAge(a);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void editName() {
		sc = new Scanner(System.in);
		System.out.println("\nInput name");
		name = sc.nextLine();
	}

	public void editAge() throws InputMismatchException {
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("\nInput age");
				age = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
	}

	public void printInfo() {
		System.out.println("\nName: " + name);
		System.out.println("Age: " + age);
	}
}
