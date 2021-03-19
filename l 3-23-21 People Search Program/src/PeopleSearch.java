import java.util.*;

public class PeopleSearch {
	static Scanner sc;

	public static void main(String[] args) throws InputMismatchException {
		FlexArray a = new FlexArray(0);
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("How many people do you want to input?");
				int count = sc.nextInt();
				for(int i = 0; i < count; i++) {
					a.add();
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("\nEnter in number for the corresponding option");
				System.out.println("1. Add person into array");
				System.out.println("2. Search for person with sequential search");
				System.out.println("3. Search for person with binary search");
				System.out.println("4. Print all people in alphabetical order");
				System.out.println("5. End program");
				int option = sc.nextInt();
				if(option < 1 || option > 5) {
					System.out.println("Make sure input is between 1 and 5");
					continue;
				}
				if(option == 1) a.add();
				else if(option == 2) a.sequentialSearch();
				else if(option == 3) a.binarySearch();
				else if(option == 4) a.printAll();
				else {
					sc.close();
					System.out.println("Program ended");
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
	}
}
