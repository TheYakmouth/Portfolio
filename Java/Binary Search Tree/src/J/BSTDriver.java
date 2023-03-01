package J;

import J.BST;

public class BSTDriver {

	public static void main(String[] args) {
		BST<Cryptid> b = new BST<Cryptid>();
		
		b.add(new Chupacabra("Jose", 6.0));
		b.add(new Chupacabra("Anna", 4.6));
		b.add(new Chupacabra("Samuel", 8.9));
		b.add(new Chupacabra("John", 7.5));
		
		b.add(new Yeti("Beatrix", 9.2));
		b.add(new Yeti("Rick", 3.3));
		b.add(new Yeti("Margot", 5.2));
		b.add(new Yeti("Sharon", 7.1));
		
		System.out.println("Inorder: ");
		b.inorder();
		System.out.println("Postorder: ");
		b.postorder();
		System.out.println("Preorder: ");
		b.preorder();
		System.out.println("Height: " + b.getMaxHeight());
		
		for(Cryptid c: b) System.out.println(c.rampage());

	}

}
