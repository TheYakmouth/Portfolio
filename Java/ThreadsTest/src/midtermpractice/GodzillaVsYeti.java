package midtermpractice;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class GodzillaVsYeti {
	private final int numYeti = 4;
	private final int numAttacksPerYeti = 20;
	Random r = new Random();

	// Implemented queue for attacks
	Queue<Attack> attacks = new LinkedList<Attack>();

	List<Yeti> yetis = new ArrayList<Yeti>();
	List<Thread> yetiThreads = new ArrayList<Thread>();

	public static void main(String[] args) {
		GodzillaVsYeti story = new GodzillaVsYeti();
		story.carnage();
	}

	public void carnage() {
		for (int counter = 0; counter < numYeti; counter++) {
			Yeti currYeti = new Yeti("Yeti " + counter, numAttacksPerYeti);
			Thread currThread = new Thread(currYeti);
			yetiThreads.add(currThread);
		}

		// created the two Kaiju
		Kaiju k1 = new Kaiju("Godzilla");
		Kaiju k2 = new Kaiju("Mothra");
		// created a thread for each of them
		Thread t1 = new Thread(k1);
		Thread t2 = new Thread(k2);
		// start the two threads
		t1.start();
		t2.start();

		// start all the Yeti threads, using a loop
		for (Thread t : yetiThreads) {
			t.start();
		}

		// Keeps threads running as long as there are attacks in the queue
		// or the yeti threads are still running
		while (!(attacks.isEmpty() || yetisAreAttacking() == true)) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean yetisAreAttacking() {
		// returns whether the yeti threads are still running or not
		for (Thread t : yetiThreads) {
			if (t.getState() != State.TERMINATED) {
				return true;
			}
		}
		return false;
	}

	public void reportAttack(Attack c) {
		System.out.printf("%s mounts an attack of severity %d\n", c.getMonsterName(), c.getSeverity());
		attacks.add(c);
	}

	public synchronized void repelAttack(String monsterName) {
		try {
			// if there are no attacks, sleep until there is at least one
			while (attacks.isEmpty()) {
				Thread.sleep(1);
			}

			int severity = attacks.poll().getSeverity();
			System.out.printf("%s repels attack of severity %d\n", monsterName, severity);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private class Attack {
		private String monsterName;
		private int severity;

		public Attack(String nameIn, int severityIn) {
			monsterName = nameIn;
			severity = severityIn;
		}

		public int getSeverity() {
			return severity;
		}

		public String getMonsterName() {
			return monsterName;
		}

	}

	private class Yeti implements Runnable {
		private String name;
		private int numAttacks;

		public Yeti(String s, int numAttacksIn) {
			name = s;
			numAttacks = numAttacksIn;
		}

		@Override
		public void run() {
			// Creates attacks from the yeti and reports them
			for (int i = 0; i < numAttacks; i++) {
				try {
					Attack newAttack = new Attack(name, r.nextInt(10));
					reportAttack(newAttack);
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class Kaiju implements Runnable {
		private String name;

		public Kaiju(String string) {
			name = string;
		}

		@Override
		public void run() {
			// Repel the attacks while there are attacks in the queue or the yeti threads
			// are still running
			while (!(attacks.isEmpty()) || yetisAreAttacking()) {
				repelAttack(name);
			}
		}
	}
}