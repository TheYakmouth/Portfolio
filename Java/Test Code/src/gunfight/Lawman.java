package gunfight;

public class Lawman extends Gunfighter {
	public Lawman(String nameIn) {
		this.name = nameIn;
		health = 1.0;
		accuracy = 0.5;
		deadliness = 0.25;
	}

	@Override
	void shoot(Gunfighter g) {
		if (r.nextDouble() < accuracy) {
			System.out.println(name + " the Lawman shot at Cowboy " + g.getName() + " and succeeds");
			g.recieveInjury(deadliness);
		} else
			System.out.println(name + " the Lawman shot at Cowboy " + g.getName() + " and misses");

	}

	@Override
	public String toString() {
		return (name + " is a Lawman with " + String.valueOf(health) + " health");
	}

}
