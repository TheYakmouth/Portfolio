package set;

import java.util.List;

public interface SetADT<T> {
	public void add(T item);

	public void remove(T item);

	public boolean contains(T item);

	public SetADT<T> union(SetADT<T> otherSet);

	public SetADT<T> intersection(SetADT<T> otherSet);

	public boolean equals(SetADT<T> otherSet);

	public List<T> toList();

	public int size();
}