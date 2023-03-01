package K;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	public List<Student> quickSort(List<Student> list) {
		if (list.size() <= 1) {
			return list;
		}
		Student pivot = list.get((list.size() / 2));
		list.remove(pivot);
		List<Student> lessThanPivot = new ArrayList<Student>();
		List<Student> greaterThanPivot = new ArrayList<Student>();
		for (Student s : list) {
			if (s.compareTo(pivot) <= 0) {
				lessThanPivot.add(s);
			} else {
				greaterThanPivot.add(s);
			}
		}
		lessThanPivot = quickSort(lessThanPivot);
		greaterThanPivot = quickSort(greaterThanPivot);

		List<Student> combined = new ArrayList<Student>();
		for (Student l : lessThanPivot) {
			combined.add(l);
		}
		combined.add(pivot);
		for (Student g : greaterThanPivot) {
			combined.add(g);
		}
		return combined;
	}

	public void swap(int array[], int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		for (int x : array)
			System.out.print(x + " ");
		System.out.println();
	}

	public boolean binarySearch(List<Student> students, Double GPAIn) {
		boolean GPAEqual;
		if (students.size() <= 1) {
			Student s = students.get(0);
			boolean baseCase = false;
			Double absoluteValue = Math.abs(GPAIn - s.getGPA());
			System.out.println("GPA In: "+GPAIn+", Closest Student's GPA: "+s.getGPA());
			if (absoluteValue <= 0.01) {
				baseCase = true;
			}
			return baseCase;
		} else {
			Student middle = students.get((students.size() / 2));
			if (Math.abs(GPAIn - middle.getGPA()) <= 0.01) {
				int middleIndex = students.indexOf(middle);
				GPAEqual = binarySearch(students.subList(middleIndex, middleIndex + 1), GPAIn);
			} else if (GPAIn < middle.getGPA()) {
				GPAEqual = binarySearch(students.subList(0, students.size() / 2), GPAIn);
			} else {
				GPAEqual = binarySearch(students.subList((students.size() / 2), students.size()), GPAIn);
			}
		}
		return GPAEqual;
	}
}
