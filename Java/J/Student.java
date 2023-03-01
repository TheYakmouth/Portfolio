package J;

import java.util.LinkedList;
import java.util.List;

public class Student extends MergeSort implements Comparable<Student> {
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
		// 1.) Test that empty list does not break sorting algorithm
		MergeSort testCaseOne = new MergeSort();
		List<Student> studentListOne = new LinkedList<Student>();
		System.out.println("Empty Student List: ");
		for (Student s : studentListOne) {
			System.out.print(s + "   ");
		}
		studentListOne = testCaseOne.mergeSort(studentListOne);
		System.out.println("Empty Student List After Sort: ");
		for (Student s : studentListOne) {
			System.out.print(s + "   ");
		}
		System.out.println();

		// 2.) Test that one Student in list works
		MergeSort testCaseTwo = new MergeSort();
		List<Student> studentListTwo = new LinkedList<Student>();
		studentListTwo.add(new Student("Samuel", 2.8));

		System.out.println("One Student In List Before Sort: ");
		for (Student s : studentListTwo) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListTwo = testCaseTwo.mergeSort(studentListTwo);

		System.out.println("One Student In List After Sort: ");
		for (Student s : studentListTwo) {
			System.out.print(s + "   ");
		}
		System.out.println();
		System.out.println();

		// 3.) Test that multiple Students in list works and sorts correctly
		MergeSort testCaseThree = new MergeSort();
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

		System.out.println("Multiple Students In List Before Sort: ");
		for (Student s : studentListThree) {
			System.out.print(s + "   ");
		}
		System.out.println();

		studentListThree = testCaseThree.mergeSort(studentListThree);

		System.out.println("Multiple Students In List After Sort: ");
		for (Student s : studentListThree) {
			System.out.print(s + "   ");
		}
		System.out.println();
		System.out.println();

		// 4.) Test that multiple Students with equal GPAs works and sorts correctly
		MergeSort testCaseFour = new MergeSort();
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

		studentListFour = testCaseFour.mergeSort(studentListFour);

		System.out.println("Multiple Students Same GPAs In List After Sort: ");
		for (Student s : studentListFour) {
			System.out.print(s + "   ");
		}
	}
}
