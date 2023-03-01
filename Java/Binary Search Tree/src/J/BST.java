package J;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<T extends Comparable<T>> {
	protected Node<T> root, left, right;

	public BST() {
		root = null;
		left = null;
		right = null;
	}

	public void add(T element) {
		if (root == null) {
			root = new Node<T>(element);
		} else {
			Node<T> search = root;
			Node<T> parent = root;
			while (search != null) {
				if (element.compareTo(search.element) < 0) {
					parent = search;
					search = search.left;
				} else if (element.compareTo(search.element) > 0) {
					parent = search;
					search = search.right;
				} else
					return;
			}
			if (element.compareTo(parent.getElement()) < 0)
				parent.left = new Node<T>(element);
			else
				parent.right = new Node<T>(element);
		}
	}

	public void remove(T element) {
		if (root == null) {
			return;
		} else {
			if (search(element) == true) {
				Node<T> current = root;
				while (current != null) {
					if (element.compareTo(current.element) < 0) {
						current = current.left;
					} else if (element.compareTo(current.element) > 0) {
						current = current.right;
					} else {
						// remove and replace the value with subtree
						Node<T> removedNode = current;
						if (removedNode.left == null || removedNode.right == null) {
							if (removedNode.left != null)
								removedNode = removedNode.left;
							else
								removedNode = removedNode.right;
						} else {

						}
					}
				}
			}
		}

	}

	public int size() {
		int counter = 0;
		if (root == null)
			return counter;
		else {
			Stack<Node<T>> treeStack = new Stack<Node<T>>();
			Node<T> current = root;
			while (current != null || !treeStack.empty()) {
				while (current != null) {
					treeStack.push(current);
					current = current.left;
				}
				current = treeStack.pop();
				counter++;
				current = current.right;
			}
		}
		return counter;
	}

	public boolean search(T key) {
		Node<T> current = root;
		while (current != null) {
			if (key.compareTo(current.element) < 0) {
				current = current.left;
			} else if (key.compareTo(current.element) > 0) {
				current = current.right;
			} else
				return true;
		}
		return false;

	}

	public Node<T> get(T element) {
		Node<T> current = root;
		while (current != null) {
			if (element.compareTo(current.element) < 0) {
				current = current.left;
			} else if (element.compareTo(current.element) > 0) {
				current = current.right;
			} else
				return current;
		}
		return current;
	}

	public void showAll() {
		List<T> binaryTreeElements = new ArrayList<T>();
		if (root == null)
			return;
		else {
			Stack<Node<T>> treeStack = new Stack<Node<T>>();
			Node<T> current = root;
			while (current != null || !treeStack.empty()) {
				while (current != null) {
					treeStack.push(current);
					current = current.left;
				}
				current = treeStack.pop();
				binaryTreeElements.add(current.getElement());
				current = current.right;
			}
		}
		for (T element : binaryTreeElements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public void inorder() {
		// TODO Auto-generated method stub
		
	}

	public void postorder() {
		// TODO Auto-generated method stub
		
	}

	public void preorder() {
		// TODO Auto-generated method stub
		
	}

	public String getMaxHeight() {
		// TODO Auto-generated method stub
		return null;
	}
}
