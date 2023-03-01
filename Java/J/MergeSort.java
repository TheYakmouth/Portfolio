package J;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

	public List<Student> mergeSort(List<Student> list) {
		if (list.size() <= 1) {
			return list;
		}
		List<Student> firstHalf = mergeSort(list.subList(0, (list.size() / 2)));
		List<Student> secondHalf = mergeSort(list.subList((list.size() / 2), list.size()));
		return list = merge(firstHalf, secondHalf);
	}

	public List<Student> merge(List<Student> firstHalfIn, List<Student> secondHalfIn) {
		List<Student> combined = new LinkedList<Student>();
		List<Student> firstHalf = new ArrayList<Student>(firstHalfIn);
		List<Student> secondHalf = new ArrayList<Student>(secondHalfIn);
		while (firstHalf.size() > 0 && secondHalf.size() > 0) {
			int compare = firstHalf.get(0).compareTo(secondHalf.get(0));
			if (compare <= 0) {
				combined.add(firstHalf.get(0));
				firstHalf.remove(0);
				continue;
			} else if (compare > 0) {
				combined.add(secondHalf.get(0));
				secondHalf.remove(0);
				continue;
			}
		}
		if (firstHalf.isEmpty()) {
			for (Student s : secondHalf) {
				combined.add(s);
			}
		} else if (secondHalf.isEmpty()) {
			for (Student s : firstHalf) {
				combined.add(s);
			}
		}
		return combined;
	}
}
