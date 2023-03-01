package J;

public class Chupacabra extends Cryptid {

	public Chupacabra(String nameIn, Double ferocityIn) {
		name = nameIn;
		ferocity = ferocityIn;
	}

	@Override
	public int compareTo(Cryptid c) {
		if (this.ferocity > c.getFerocity())
			return 1;
		else if (this.ferocity < c.getFerocity())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return (name + " the Chupacabra has Feriocity: " + ferocity + " \n");
	}

	@Override
	public String rampage() {
		return (name + " the Chupacabra ferociously eats its victims\n");
	}

}
