package monsterpersistence;

import java.io.Serializable;

public class Monster implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String hometown;
	private String rampageBehavior;

	public Monster(String nameIn, String hometownIn, String rampageBehaviorIn) {
		name = nameIn;
		hometown = hometownIn;
		rampageBehavior = rampageBehaviorIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getRampageBehavior() {
		return rampageBehavior;
	}

	public void setRampageBehavior(String rampageBehavior) {
		this.rampageBehavior = rampageBehavior;
	}

	@Override
	public	boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null || other.getClass() != this.getClass())
			return false;
		Monster otherMonster = (Monster) other;
		if (otherMonster.name.equals(name) && otherMonster.hometown.equals(hometown)
				&& otherMonster.rampageBehavior.equals(rampageBehavior))
			return true;
		return false;
	}

	public String toString() {
		return name + " from " + hometown + " likes to " + rampageBehavior;
	}
}