package Shape3D;

public class ShapeDriver {

	public static void main(String[] args) {
		Cube cube = new Cube(6);
		Sphere sphere = new Sphere(4);
		
		cube.getEquivilantCube();
		sphere.getEquivilantCube();
		
		System.out.println(cube.toString());
		System.out.println(sphere.toString());
		

	}

}
