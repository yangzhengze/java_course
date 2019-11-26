package asu.test2;

public class Rectangle extends Polygon {
	protected double length, width;
	
	public Rectangle(double length, double width) {
		super("Rectangle" + (length == width ? "::Square" : ""));
		setLengthAndWidth(length, width);
	}
	final public void setLengthAndWidth(double a, double b) {
		this.length = a;
		this.width = b;
		update();
		calcPerimeter();
		calcArea();
	}
	@Override
	protected void calcPerimeter() {
		double perimeter = 2 * (length + width);
		setPerimeter(perimeter);
	}

	@Override
	protected void calcArea() {
		double area = length * width;
		setArea(area);

	}
	private void update() {
		if (this.length < this.width) {
			double t = this.length; 
			this.length = this.width; 
			this.width = t;
		}
	}
	public String toString() {
		String result = super.toString();
		if (length != width) {
			result += '\t' + "Length = " + fmt.format(length);
			result += '\t' + "Width = " + fmt.format(width);
		}
		return result;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}
