package scavengers;

public abstract class Scavenger {
	protected int mouthCapacity;
	protected String animal;
	protected int weight;
	protected String scrap;

	public abstract String toString();

	abstract void bite(Scrap s);
}
