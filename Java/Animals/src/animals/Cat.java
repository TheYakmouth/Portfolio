package animals;

public class Cat extends Predator{
	
	public Cat(String nameIn, double weightIn) {
		name = nameIn;
		weight = weightIn;
	}

	@Override
	void call() {
		System.out.println(name+" says 'Meow'");
	}

	@Override
	public String toString() {
		return (name+" is a Cat weighing "+weight+" grams.");
	}

	@Override
	void predate(Prey p) {
		double pWeight = p.getWeight();
		eat(pWeight);
		System.out.println(name+" heard "+p.getName()+"'s call and made them into a lovely dinner.");
	}
	

}
