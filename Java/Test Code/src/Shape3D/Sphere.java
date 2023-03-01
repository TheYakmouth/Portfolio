package Shape3D;

public class Sphere extends Shape3D {
	protected double radius;

	public Sphere(double radius) {
		this.radius = radius;
		volume = (4 / 3) * (Math.PI) * (Math.pow(radius, 3));
	}

	@Override
	void getEquivilantCube() {
		double cubeSide = Math.cbrt(volume);
		System.out.println("Cube with volume of a sphere with radius " + String.valueOf(radius) + " has a side length "
				+ String.valueOf(cubeSide));

	}

	@Override
	public String toString() {
		return ("Sphere with radius " + String.valueOf(radius) + " and volume of " + String.valueOf(volume));
	}

}
