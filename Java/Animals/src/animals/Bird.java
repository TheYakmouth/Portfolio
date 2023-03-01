package animals;

public class Bird extends Prey{
	
	public Bird(double weightIn, String nameIn) {
		name = nameIn;
		weight = weightIn;
		}

	@Override
	void flee() {
		System.out.println(name+" flys away from an ominous threat.");
	}

	@Override
	void call() {
		System.out.println(name+" chirps looking for another bird.");
	}

	@Override
	public String toString() {
		return (name+" is a Bird weighing "+weight+" grams.");
	}

}
