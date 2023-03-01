package animals;

public abstract class Animal {
	protected String name;
	protected double weight;
	
	public void eat(double foodIn) {
		weight = weight + foodIn;
	}
	
	abstract void call();
	
	public abstract String toString();
	
	public double getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}

}
