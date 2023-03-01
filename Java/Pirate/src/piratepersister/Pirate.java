package piratepersister;

import java.io.Serializable;

public class Pirate implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private double amountOfRum;

	
	public Pirate() {}
	
	public Pirate(String nameIn, double rumIn) {
		name = nameIn;
		amountOfRum = rumIn;
	}
	public String getName() {
		return name;
	}
	public double getRum() {
		return amountOfRum;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setRum(double amountOfRum) {
		this.amountOfRum = amountOfRum;
	}

	
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null || other.getClass() != this.getClass())
			return false;
		Pirate otherPirate = (Pirate) other;
		if (otherPirate.name.equals(name) && otherPirate.amountOfRum==(amountOfRum))
			return true;
		return false;
	}
	
	public String toString () {
		return ("Pirate: "+name+"\nRum Amount: "+String.valueOf(amountOfRum));
	}
}