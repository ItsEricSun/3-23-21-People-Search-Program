import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FlexArray {
	static Scanner sc;
	private Person[] a;

	public FlexArray(int s) {
		a = new Person[s];
	}

	public void add() throws InputMismatchException {
		String name;
		int age;
		Person[] a2 = Arrays.copyOf(a, a.length + 1);
		for(int i = 0; i < a.length; i++) {
			a2[i] = a[i];
		}
		sc = new Scanner(System.in);
		System.out.println("\nInput name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Input age");
				age = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		Person p = new Person(name, age);
		a2[a.length] = p;
		a = new Person[a2.length];
		a = a2;
	}

	public void sequentialSearch() {
		int comparisons = 0;
		sc = new Scanner(System.in);
		System.out.println("\nInput name");
		String name = sc.nextLine();
		for(int i = 0; i < a.length; i++) {
			comparisons++;
			if(a[i].getName().equals(name)) {
				System.out.println("Comparisons: " + comparisons);
				edit(a[i], i);
				return;
			}
		}
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Person not found");
	}

	public void binarySearch() {
		Person[] sortedA = sort();
		a = sortedA;
		int min = 0;
		int max = sortedA.length;
		int comparisons = 0;
		sc = new Scanner(System.in);
		System.out.println("\nInput name");
		String name = sc.nextLine();
		while(min < max) {
			comparisons++;
			int mid = (min + max) / 2;
			if(a[mid].getName().compareTo(name) < 0) {
				min = mid + 1;
			} else if(a[mid].getName().compareTo(name) > 0) {
				max = mid;
			} else if(a[mid].getName().equals(name)) {
				System.out.println("Comparisons: " + comparisons);
				edit(a[mid], mid);
				return;
			}
		}
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Person not found");
	}

	public void edit(Person p, int i) {
		while(true) {
			sc = new Scanner(System.in);
			p.printInfo();
			try {
				System.out.println("\nEnter in number for the corresponding option");
				System.out.println("1. Edit name");
				System.out.println("2. Edit age");
				System.out.println("3. Delete person");
				System.out.println("4. Done");
				int option = sc.nextInt();
				if(option < 1 || option > 4) {
					System.out.println("Make sure input is between 1 and 5");
					continue;
				}
				if(option == 1) p.editName();
				else if(option == 2) p.editAge();
				else if(option == 3) {
					remove(a, i);
					System.out.println("Person removed");
					return;
				} else return;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
	}

	public void remove(Person[] a, int r) {
		Person[] a2 = new Person[a.length - 1];
		for(int i = 0; i < a.length; i++) {
			if(i == r) continue;
			else if(i > r) a2[i - 1] = a[i];
			else a2[i] = a[i];
		}
		this.a = a2;
	}

	public void printAll() {
		if(a.length == 0) {
			System.out.println("Array empty");
			return;
		}
		Person[] sortedA = sort();
		for(int i = 0; i < sortedA.length; i++) {
			sortedA[i].printInfo();
		}
	}

	public Person[] sort() {
		Person[] sortedA = Arrays.copyOf(a, a.length);
		for(int i = 0; i < sortedA.length - 1; i++) {
			int target = i;
			for(int j = i + 1; j < sortedA.length; j++) {
				if(sortedA[target].getName().compareTo(sortedA[j].getName()) > 0) {
					target = j;
				}
			}
			swap(sortedA, target, i);
		}
		return sortedA;
	}

	public void swap(Person[] a, int target, int i) {
		Person temp = a[target];
		a[target] = a[i];
		a[i] = temp;
	}
}
