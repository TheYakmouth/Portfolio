package Shape3D;

public abstract class Shape3D {
	protected double volume;
	
	abstract void getEquivilantCube();
	
	public abstract String toString();
	
	public boolean isLargerThan(Shape3D shape) {
		if (shape.getVolume() > this.volume)
			return true;
		else
			return false;
	}
	
	public double getVolume() {
		return volume;
	}
	
}
