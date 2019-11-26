package asu.test2;

public class RegularHexagon extends Hexagon{
	private double side;
	public RegularHexagon(double side) {
		super(true);
		setSide(side);
	}
	public void setSide(double side) {
		this.side = side;
		calcPerimeter();
		calcArea();
	}
	public double getSide() {
		return side;
	}
	protected void calcPerimeter() {
		double perimeter = side * 6;
		setPerimeter(perimeter);
	}
	protected void calcArea() {
		double area = 3 * Math.sqrt(3) / 2 * side * side;
		setArea(area);
	}
	public String toString() {
		String result = super.toString();
		result += "\tSide = " + fmt.format(side);
		return result;
	}
}