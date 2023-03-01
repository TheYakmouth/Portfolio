package scavengers;

public class Vulture extends Scavenger {
	public Vulture(int mouthCapacityIn, String animalIn) {
		mouthCapacity = mouthCapacityIn;
		animal = animalIn;
	}

	@Override
	public String toString() {
		if (weight < mouthCapacity)
			return (animal + " bites " + weight + " mg scrap of " + scrap + " and gets " + weight + " mg");
		else
			return (animal + " bites " + weight + " mg scrap of " + scrap + " and gets " + mouthCapacity + " mg");
	}

	@Override
	void bite(Scrap s) {
		weight = s.getScrapWeight();
		scrap = s.getScrapType();
		System.out.println(toString());
		s.reduce(mouthCapacity);

	}

}
