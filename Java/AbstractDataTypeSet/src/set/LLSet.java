package set;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("hiding")
public class LLSet<String> implements SetADT<String> {
	protected List<String> stringSet = new LinkedList<String>();

	@Override
	public void add(String item) {
		stringSet.add(item);
	}

	@Override
	public void remove(String item) {
		if (stringSet.size() == 0) {
			return;
		}
		for (int i = 0; i < stringSet.size(); i++) {
			if (stringSet.get(i).equals(item)) {
				stringSet.remove(i);
				return;
			}
		}
		return;
	}

	@Override
	public boolean contains(String item) {
		if (stringSet.size() == 0) {
			return false;
		}
		for (int i = 0; i < stringSet.size(); i++) {
			if (stringSet.get(i).equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public SetADT<String> union(SetADT<String> otherSet) {
		SetADT<String> unionSet = new LLSet<String>();

		boolean instanceLT = (stringSet.size() < otherSet.size());
		int size = (instanceLT ? stringSet.size() : otherSet.size());

		for (int i = 0; i < size; i++) {
			if (!(unionSet.contains(stringSet.get(i)))) {
				unionSet.add(stringSet.get(i));
			}
			if (!(unionSet.contains(otherSet.toList().get(i)))) {
				unionSet.add(otherSet.toList().get(i));
			}
		}
		if (stringSet.size() == otherSet.size()) {
			return unionSet;
		} else if (instanceLT && (!(unionSet.contains(otherSet.toList().get(otherSet.size()-1))))) {
			unionSet.add(otherSet.toList().get(otherSet.size()-1));
		} else {
			unionSet.add(stringSet.get(stringSet.size()-1));
		}
		return unionSet;
	}

	@Override
	public SetADT<String> intersection(SetADT<String> otherSet) {
		SetADT<String> intersectSet = new LLSet<String>();
		for (int i = 0; i < stringSet.size(); i++) {
			if (otherSet.contains(stringSet.get(i))) {
				intersectSet.add(stringSet.get(i));
			}
		}
		return intersectSet;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean equals(SetADT<String> otherSet) {
		if (stringSet.size() != otherSet.size()) {
			return false;
		}
		for (int i = 0; i < stringSet.size(); i++) {
			if (!(otherSet.contains(stringSet.get(i)))) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public List<String> toList() {
		return stringSet;
	}

	@Override
	public int size() {
		return stringSet.size();
	}

}
