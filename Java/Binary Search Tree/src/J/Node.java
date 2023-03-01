package J;

public class Node<T extends Comparable<T>> {
	T element;
	Node<T> root;
	Node<T> left;
	Node<T> right;

	public Node(T e) {
		element = e;
	}

	public Node(T element, Node<T> right, Node<T> left) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public T getElement() {
		return element;
	}

	public Node<T> getRight() {
		return right;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

}
