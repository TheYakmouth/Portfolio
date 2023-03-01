package gunfight;

import java.util.ArrayList;
import java.util.List;

public class Shootout {
	List<Cowboy> cowboys = new ArrayList<Cowboy>();
	List<Lawman> lawmen = new ArrayList<Lawman>();

	public void addCowboy(Cowboy c) {
		cowboys.add(c);
	}

	public void addLawman(Lawman l) {
		lawmen.add(l);
	}

	public boolean cowboyStatus() {
		int counter = 0;
		for (Cowboy c : cowboys)
			if (c.getHealth() > 0)
				counter++;
		if (counter == 0) {
			System.out.println("Lawmen Win!");
			return false;
		} else
			return true;
		// System.out.println("Lawmen Win!");
	}

	public boolean lawmenStatus() {
		int counter = 0;
		for (Lawman c : lawmen)
			if (c.getHealth() > 0)
				counter++;
		if (counter == 0) {
			System.out.println("Cowboys Win!");
			return false;
		} else
			return true;
		// System.out.println("Cowboys Win!");
	}

	public void fight() {
		while (lawmenStatus() == true && cowboyStatus() == true) {
			for (Cowboy c : cowboys) {
				for (Lawman l : lawmen) {
					if (c.getHealth() > 0 && l.getHealth() > 0) {
						c.shoot(l);
						if (l.getHealth() > 0) {
							l.shoot(c);
						}
					}
				}
			}
		}
	}

}
