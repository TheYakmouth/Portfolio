package animals;

public class Mouse extends Prey{
	
	public Mouse(double weightIn, String nameIn) {
		name = nameIn;
		weight = weightIn;
	}

	@Override
	void flee() {
		System.out.println(name+" runs away from an ominous threat.");
	}

	@Override
	void call() {
		System.out.println(name+" sqeaks looking for another mouse.");
	}

	@Override
	public String toString() {
		return (name+" is a Mouse weighing "+weight+" grams.");
	}

}
