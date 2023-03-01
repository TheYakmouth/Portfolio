package gunfight;

public class Cowboy extends Gunfighter {
	public Cowboy(String nameIn) {
		this.name = nameIn;
		health = 1.0;
		accuracy = 0.25;
		deadliness = 0.5;
	}

	@Override
	void shoot(Gunfighter g) {
		if (r.nextDouble() < accuracy) {
			System.out.println(name + " the Cowboy shot at Lawman " + g.getName() + " and succeeds");
			g.recieveInjury(deadliness);
		} else
			System.out.println(name + " the Cowboy shot at Lawman " + g.getName() + " and misses");

	}

	@Override
	public String toString() {
		return (name + " is a Cowboy with " + String.valueOf(health) + " health");
	}

}
