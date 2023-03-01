package scavengers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Picnic {
	public static void feast(Scavenger s, Scrap scrap) {
		s.bite(scrap);
	}

	public static void main(String args[]) {
		Random r = new Random();
		List<Scavenger> scavengers = new ArrayList<Scavenger>();

		Scrap cheese = new Scrap();
		cheese.setScrapType("moldy cheese");
		cheese.setScrapWeight(1000);

		Vulture v = new Vulture(50, "Vulture");
		scavengers.add(v);

		for (int i = 1; i <= r.nextInt(10); i++) {
			Ant a = new Ant(1, "Ant");
			scavengers.add(a);
		}

		Ant a = new Ant(1, "Ant");
		scavengers.add(a);

		while (cheese.getScrapWeight() != 0) {
			for (Scavenger s : scavengers) {
				if (cheese.getScrapWeight() == 0)
					break;
				else
					feast(s, cheese);
			}
		}
		System.out.println("No more " + cheese.getScrapType());
	}
}
