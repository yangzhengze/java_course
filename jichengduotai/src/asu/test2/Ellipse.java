package asu.test2;

public class Ellipse extends Shape{
	protected double a, b;
	public Ellipse(double a, double b) {
		super("Ellipse" + (a == b ? "::Circle" : ""));
		setSemimajorAndSemiminor(a, b);
	}
	protected void calcPerimeter() {
		double perimeter = 2 * Math.PI * b + 4 * (a - b);
		setPerimeter(perimeter);
	}
	protected void calcArea() {
		double area = Math.PI * a * b;
		setArea(area);
	}
	final public void setSemimajorAndSemiminor(double a, double b) {
		this.a = a;
		this.b = b;
		update();
		calcPerimeter();
		calcArea();
	}
	final public double getSemimajor() {
		return a;
	}
	final public double getSemiminor() {
		return b;
	}
	public String toString() {
		String result = super.toString();
		if (a != b) {
			result += "\tSemimajor = " + fmt.format(a);
			result += "\tSemiminor = " + fmt.format(b);
		}
		return result;
	}
	private void update() {
		if (this.a < this.b) {
			double t = this.a; 
			this.a = this.b; 
			this.b = t;
		}
	}
}