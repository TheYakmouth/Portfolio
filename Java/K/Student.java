package K;

import java.util.LinkedList;
import java.util.List;

public class Student extends QuickSort implements Comparable<Student> {
	protected String name;
	protected Double GPA;

	public Student(String name, Double GPA) {
		this.name = name;
		this.GPA = GPA;
	}

	public Double getGPA() {
		return GPA;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return ("Name: " + name + " GPA: " + GPA);
	}

	@Override
	public int compareTo(Student s) {
		return (GPA.compareTo(s.getGPA()));
	}

	public static void main(String[] args) {
		// 1.) Test that sorting method works without exception
		System.out.println("Test 1.) No Exceptions Thrown:");
		QuickSort testOne = new QuickSort();
		List<Student> studentListOne = new LinkedList<Student>();
		studentListOne.add(new Student("Samuel", 2.8));
		studentListOne.add(new Student("John", 3.3));
		studentListOne.add(new Student("Beatrix", 3.8));
		studentListOne.add(new Student("Margot", 3.5));

		System.out.println("List before sort:");
		for (Student s : studentListOne) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListOne = testOne.quickSort(studentListOne);

		System.out.println("List after sort:");
		for (Student s : studentListOne) {
			System.out.print(s + "   ");
		}
		System.out.println();
		System.out.println();

		// 2.) Test that sorting method with no entries
		System.out.println("Test 2.) Method Works With No Entries:");
		QuickSort testTwo = new QuickSort();
		List<Student> studentListTwo = new LinkedList<Student>();

		System.out.println("Empty List before sort:");
		for (Student s : studentListTwo) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListTwo = testTwo.quickSort(studentListTwo);

		System.out.println("Empty List after sort:");
		for (Student s : studentListTwo) {
			System.out.print(s + "   ");
		}
		System.out.println();

		// 2.) Test that sorting method with no entries
		System.out.println("Test 3.) Method Works With Multiple Entries:");
		QuickSort testThree = new QuickSort();
		List<Student> studentListThree = new LinkedList<Student>();
		studentListThree.add(new Student("Samuel", 2.8));
		studentListThree.add(new Student("John", 3.3));
		studentListThree.add(new Student("Beatrix", 3.8));
		studentListThree.add(new Student("Margot", 3.5));
		studentListThree.add(new Student("Samantha", 2.9));
		studentListThree.add(new Student("Babe", 4.0));
		studentListThree.add(new Student("Marcel", 3.2));
		studentListThree.add(new Student("Ryan", 3.6));
		studentListThree.add(new Student("Giovanni", 3.8));
		studentListThree.add(new Student("Joe", 2.2));

		System.out.println("Large List before sort:");
		for (Student s : studentListThree) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListThree = testThree.quickSort(studentListThree);

		System.out.println("Large List after sort:");
		for (Student s : studentListThree) {
			System.out.print(s + "   ");
		}
		System.out.println();
		System.out.println();

		// 4.) Test that multiple Students with equal GPAs works and sorts correctly
		System.out.println("Test 4.) Method Works With Multiple Entries and equal GPAs:");
		QuickSort testFour = new QuickSort();
		List<Student> studentListFour = new LinkedList<Student>();
		studentListFour.add(new Student("Samuel", 3.0));
		studentListFour.add(new Student("John", 3.5));
		studentListFour.add(new Student("Beatrix", 3.0));
		studentListFour.add(new Student("Margot", 3.5));
		studentListFour.add(new Student("Samantha", 3.0));

		System.out.println("Multiple Students Same GPAs In List Before Sort: ");
		for (Student s : studentListFour) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListFour = testFour.quickSort(studentListFour);

		System.out.println("Multiple Students Same GPAs In List After Sort: ");
		for (Student s : studentListFour) {
			System.out.print(s + "   ");
		}
		System.out.println();
		System.out.println();

		// 5.) Test that multiple Students with equal GPAs works and sorts correctly
		System.out.println("Test 5.) Binary Search Method for \"Equal\" GPAs:");
		QuickSort testFive = new QuickSort();
		List<Student> studentListFive = new LinkedList<Student>();
		studentListFive.add(new Student("Samuel", 2.83));
		studentListFive.add(new Student("John", 3.37));
		studentListFive.add(new Student("Beatrix", 3.80));
		studentListFive.add(new Student("Margot", 3.55));
		studentListFive.add(new Student("Samantha", 2.91));
		
		studentListFive = testFive.quickSort(studentListFive);

		System.out.println("Binary Search Output with Equal GPAs: ");
		System.out.println("Equals: "+testFive.binarySearch(studentListFive, 2.909));
		
		System.out.println("Binary Search Output without Equal GPAs: ");
		System.out.println("Equals: "+testFive.binarySearch(studentListFive, 3.5));
	}

}
