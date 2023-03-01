package J;

public abstract class Cryptid implements Comparable <Cryptid> {
	protected String name;
	protected Double ferocity;
	
	public void setName(String nameIn) {
		name = nameIn;
	}
	
	public void setFerocity(Double ferocityIn) {
		ferocity = ferocityIn;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getFerocity() {
		return ferocity;
	}
	
	public abstract String toString();
	
	public abstract String rampage();
		

}
