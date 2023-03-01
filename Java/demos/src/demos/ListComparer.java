package demos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListComparer {
	private Random r = new Random();
	private StopWatch s = new StopWatch();
	private List<Integer> al = new ArrayList<Integer>();
	private List<Integer> ll = new LinkedList<Integer>();

	public static void main(String[] args) {
		ListComparer l = new ListComparer();
		int addToStartCount = 200000;
		int addToEndCount = 5000000;
		int sequentialTraversalCount = 100000;
		int randomGetsCount = 200000;
		
		l.addToStartExercise(addToStartCount);
		l.addToEndExercise(addToEndCount);
		l.traverseListExercise(sequentialTraversalCount);
		l.randomGetsExercise(randomGetsCount);
	}

	public void addToStartExercise(int count) {
		ll.clear();
		al.clear();

		s.reset();
		s.start();
		addSequentialIntegersToStart(ll, count);
		s.stop();
		System.out.println("Add to start exercise with linked list took "
				+ s.getElapsedTime() + " ms");

		s.reset();
		s.start();
		addSequentialIntegersToStart(al, count);
		s.stop();
		System.out.println("Add to start exercise with array list took "
				+ s.getElapsedTime() + " ms");

	}

	public void addToEndExercise(int count) {
		ll.clear();
		al.clear();

		s.reset();
		s.start();
		addSequentialIntegersToEnd(ll, count);
		s.stop();
		System.out.println("Add to end exercise with linked list took "
				+ s.getElapsedTime() + " ms");

		s.reset();
		s.start();
		addSequentialIntegersToEnd(al, count);
		s.stop();
		System.out.println("Add to end exercise with array list took "
				+ s.getElapsedTime() + " ms");

	}

	public void traverseListExercise(int count) {
		ll.clear();
		al.clear();

		addSequentialIntegersToEnd(ll, count);
		
		s.reset();
		s.start();
		integerListSequentialGets(ll);
		s.stop();
		System.out
				.println("Sequential traversal exercise with linked list took "
						+ s.getElapsedTime() + " ms");

		addSequentialIntegersToEnd(al, count);

		s.reset();
		s.start();
		integerListSequentialGets(al);

		s.stop();
		System.out
				.println("Sequential traversal exercise with array list took "
						+ s.getElapsedTime() + " ms");

	}

	public void randomGetsExercise(int count) {
		ll.clear();
		al.clear();

		addSequentialIntegersToEnd(ll, count);

		s.reset();
		s.start();
		randomGets(ll, count);
		s.stop();
		System.out.println("Random gets exercise with linked list took "
				+ s.getElapsedTime() + " ms");

		addSequentialIntegersToEnd(al, count);
		s.reset();
		s.start();
		randomGets(al, count);
		s.stop();
		System.out.println("Random gets exercise with array list took "
				+ s.getElapsedTime() + " ms");
	}
	
	public void randomGets(List<Integer> list, int count){
		for(int counter = 0; counter < count; counter++){
			list.get(r.nextInt(list.size()-1));
		}
	}

	public void addSequentialIntegersToStart(List<Integer> list, int count) {
		list.clear();
		for (int counter = 0; counter < count; counter++) {
			list.add(0, counter);
		}
	}

	public void addSequentialIntegersToEnd(List<Integer> list, int count) {
		list.clear();
		for (int counter = 0; counter < count; counter++) {
			list.add(counter);
		}
	}

	public void integerListSequentialGets(List<Integer> list) {
		for (int counter = 0; counter < list.size(); counter++){
			list.get(counter);			
		}
	}
}
