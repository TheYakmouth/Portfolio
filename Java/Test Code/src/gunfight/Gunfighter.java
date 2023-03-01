package gunfight;

import java.util.Random;

public abstract class Gunfighter {
	protected String name;
	protected double health;
	protected double accuracy;
	protected double deadliness;

	Random r = new Random();

	public void setAccuracy(double accuracyIn) {
		this.accuracy = accuracyIn;
	}

	public String getName() {
		return name;
	}
	public double getHealth() {
		return health;
	}

	public void recieveInjury(double damage) {
		health = (health - damage);
		if (health == 0)
			System.out.println(name + " was killed!");
		else
			System.out.println(name + " was shoot for " + String.valueOf(damage) + " damage, they now has "
					+ String.valueOf(health) + " health left");
	}

	abstract void shoot(Gunfighter g);

	public abstract String toString();
}
