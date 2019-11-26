package asu.test2;

public class Square extends Rectangle {
	private double side;
	public Square(double side) {
		super(side, side);
		this.side = side;
	}
	public void setSide(double side) {
		this.side = side;
		calcPerimeter();
		calcArea();
	}
	public double getSide() {
		return side;
	}
	public String toString() {
		String result = super.toString();
		result += "\tSide = " + fmt.format(side);
		return result;
	}
}