package gunfight;

public class GunfightDriver {

	public static void main(String[] args) {
		Shootout gunfight = new Shootout();
		
		Cowboy billy = new Cowboy("Billy");
		Cowboy katy = new Cowboy("Katy");
		Cowboy joel = new Cowboy("Joel");
		Cowboy ryan = new Cowboy("Ryan");
		
		gunfight.addCowboy(billy);
		gunfight.addCowboy(katy);
		gunfight.addCowboy(joel);
		gunfight.addCowboy(ryan);
		
		Lawman john = new Lawman("John");
		Lawman sam = new Lawman("Sam");
		Lawman ruth = new Lawman("Ruth");
		Lawman chris = new Lawman("Chris");
		
		gunfight.addLawman(john);
		gunfight.addLawman(sam);
		gunfight.addLawman(ruth);
		gunfight.addLawman(chris);
		
		gunfight.fight();
		

	}

}
