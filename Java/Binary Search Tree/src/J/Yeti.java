package J;

public class Yeti extends Cryptid {

	public Yeti(String nameIn, Double ferocityIn) {
		name = nameIn;
		ferocity = ferocityIn;
	}

	@Override
	public int compareTo(Cryptid y) {
		if (this.ferocity > y.getFerocity())
			return 1;
		else if (this.ferocity < y.getFerocity())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return (name + " the Yeti has Feriocity: " + ferocity + " \n");
		
	}

	@Override
	public String rampage() {
		return (name + " the Yeti casts its victims into an ice cave\n");
		}

}
