package set;

import java.util.LinkedList;
import java.util.List;

public class SetTester {
	public static void main(String[] args) {
		SetTester st = new SetTester();
		st.testEmptySet();
		st.testAdds();
		st.testAddsAndRemoves();
		st.testContains();
		st.testSize();
		st.testUnion();
		st.testUnionContainsNoDuplicates();
		st.testIntersection();
		st.testEquals();
	}

	public void testEmptySet() {
		SetADT<String> set = new LLSet<String>();
		if (set.size() == 0)
			System.out.println("Empty list OK");
		else
			System.out.println("Error with empty list");
	}

	public void testAdds() {
		List<String> list = new LinkedList<String>();
		SetADT<String> set = new LLSet<String>();
		list.add("Arthur");
		set.add("Arthur");
		list.add("Beatrice");
		set.add("Beatrice");
		list.add("Carl");
		set.add("Carl");
		List<String> vals = set.toList();
		if (list.containsAll(vals) && vals.containsAll(list))
			System.out.println("Test adds OK");
		else
			System.out.println("Error testing adds");
	}

	public void testAddsAndRemoves() {
		List<String> list = new LinkedList<String>();
		SetADT<String> set = new LLSet<String>();
		list.add("Arthur");
		set.add("Arthur");
		set.add("Beatrice");
		list.add("Carl");
		set.add("Carl");
		set.remove("Beatrice");
		List<String> vals = set.toList();
		if (list.containsAll(vals) && vals.containsAll(list))
			System.out.println("Test adds and removes OK");
		else
			System.out.println("Error testing adds and removes");
	}

	public void testContains() {
		SetADT<String> set = new LLSet<String>();
		set.add("Arthur");
		set.add("Beatrice");
		set.add("Carl");
		if (set.contains("Beatrice"))
			System.out.println("Test contains true OK");
		else
			System.out.println("Error with test contains true");
		set.remove("Beatrice");
		if (set.contains("Beatrice"))
			System.out.println("Error with test contains false");
		else
			System.out.println("Test contains false OK");
	}

	public void testSize() {
		SetADT<String> set = new LLSet<String>();
		set.add("Arthur");
		set.add("Beatrice");
		if (set.size() == 2)
			System.out.println("Test size OK");
		else
			System.out.println("Error testing size");
	}

	public void testUnion() {
		List<String> list = new LinkedList<String>();
		SetADT<String> set1 = new LLSet<String>();
		SetADT<String> set2 = new LLSet<String>();
		list.add("Arthur");
		set1.add("Arthur");
		list.add("Beatrice");
		set1.add("Beatrice");
		list.add("Carl");
		set1.add("Carl");
		list.add("Daniel");
		set2.add("Daniel");
		list.add("Erica");
		set2.add("Erica");
		list.add("Francine");
		set2.add("Francine");
		SetADT<String> union = set1.union(set2);
		List<String> vals = union.toList();
		System.out.println("set 1 to list: " + set1.toList());
		System.out.println("set 2 to list: " + set2.toList());
		System.out.println("union: " + vals);
		if (list.containsAll(vals) && vals.containsAll(list))
			System.out.println("Test union OK");
		else
			System.out.println("Error testing union");
	}

	public void testUnionContainsNoDuplicates() {
		List<String> list = new LinkedList<String>();
		SetADT<String> set1 = new LLSet<String>();
		SetADT<String> set2 = new LLSet<String>();
		list.add("Arthur");
		set1.add("Arthur");
		list.add("Beatrice");
		set1.add("Beatrice");
		list.add("Carl");
		set1.add("Carl");
		set2.add("Carl");
		list.add("Daniel");
		set2.add("Daniel");
		list.add("Erica");
		set2.add("Erica");
		list.add("Francine");
		set2.add("Francine");
		SetADT<String> union = set1.union(set2);
		List<String> vals = union.toList();
		System.out.println("set 1 to list: " + set1.toList());
		System.out.println("set 2 to list: " + set2.toList());
		System.out.println("union: " + vals);
		for (int counter = 0; counter < vals.size(); counter++) {
			String t = vals.remove(counter);
			if (vals.contains(t)) {
				System.out.println("Error testing union: contains duplicate");
				return;
			}
		}
		System.out.println("Test union contains no duplicates OK");
	}

	public void testIntersection() {
		List<String> list = new LinkedList<String>();
		SetADT<String> set1 = new LLSet<String>();
		SetADT<String> set2 = new LLSet<String>();
		set1.add("Arthur");
		set1.add("Beatrice");
		list.add("Carl");
		set1.add("Carl");
		set2.add("Carl");
		list.add("Daniel");
		set1.add("Daniel");
		set2.add("Daniel");
		set2.add("Erica");
		SetADT<String> intersection = set1.intersection(set2);
		List<String> vals = intersection.toList();
		System.out.println("set 1 to list: " + set1.toList());
		System.out.println("set 2 to list: " + set2.toList());
		System.out.println("intersection: " + vals);
		if (list.containsAll(vals) && vals.containsAll(list))
			System.out.println("Test intersection OK");
		else
			System.out.println("Error testing intersection");
	}

	public void testEquals() {
		SetADT<String> set1 = new LLSet<String>();
		SetADT<String> set2 = new LLSet<String>();
		set1.add("Arthur");
		set1.add("Beatrice");
		set1.add("Carl");
		set2.add("Carl");
		set2.add("Beatrice");
		set2.add("Arthur");
		if (set1.equals(set2))
			System.out.println("Test equals true OK");
		else
			System.out.println("Error with test equals true");
		set1.add("Eduardo");
		if (set1.equals(set2))
			System.out.println("Error with test equals false");
		else
			System.out.println("Test equals false OK");
	}
}