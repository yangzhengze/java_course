package asu.test2;

import java.util.Random;

public class Hexagon extends Polygon {
	private Random gen = new Random();
	private boolean regular;
	public Hexagon() {
		super("Hexagon");
		regular = false;
		calcPerimeter();
		calcArea();
	}
	protected Hexagon(boolean regular) {
		super("Hexagon" + (regular ? "::RegularHexagon" : ""));
		this.regular = regular;
	}
	protected void calcPerimeter() {
		double perimeter = gen.nextDouble() * 10;
		setPerimeter(perimeter);
	}
	protected void calcArea() {
		double area = gen.nextDouble() * 10;
		setArea(area);
	}
	public String toString() {
		String result = super.toString();
		if (!regular) result += "\tRandomized";
		return result;
	}
}