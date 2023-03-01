package monsters;

//import java.time.LocalDate;

public class MonsterAttack {
	private String monsterName;
	private String location;
	private double damage;
	private String attackDate;
	
	public MonsterAttack() {}
																		/*try to make local date format*/
	public MonsterAttack(String mName, String aLocation, double mDamage, String timeOfAttack) {
		monsterName = mName;
		location = aLocation;
		damage = mDamage;
		attackDate = timeOfAttack;
	}
	
	public String getMonsterName() {
		return monsterName;
	}
	
	public void setMonsterName(String name) {
		monsterName = name;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public void setDamage(double damageIn) {
		damage = damageIn;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String locationIn) {
		location = locationIn;
	}
	
	public String getDate() {
		return attackDate;
	}
	
	public void setDate(String date) {
		attackDate = date;
	}
	
	
	public String toString() {
		return ("The monster "+monsterName+" attacked the city of "+location+" causing a massive $"
				+damage+" million in damages on "+attackDate);
	}

}
