package asu.test2;
public class Circle extends Ellipse{
	private double r;
	public Circle(double r) {
		super(r, r);
		setRadius(r);
	}
	protected void calcPerimeter() {
		double perimeter = 2 * Math.PI * r;
		setPerimeter(perimeter);
	}
	public void setRadius(double r) {
		this.r = r;
		calcPerimeter();
		calcArea();
	}
	public double getRadius() {
		return r;
	}
	public String toString() {
		String result = super.toString();
		result += "\tRadius = " + fmt.format(r);
		return result;
	}
}