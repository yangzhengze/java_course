package asu.test2;

import java.text.DecimalFormat;
/**
 * 1、矩形、正方形、椭圆、形圆形、六边形、正六边形都是形状，请以形状（Shape）为最顶层的类，
 *  设计出一个层次化的类结构，至少能够对每个形状命名，并求面积、周长

   2、写一个程序，创建若干形状，存储到数组中，实现排序算法，可以根据面积、周长对创建的图形实现排序。
 * 
 * @author asuy
 *我将Shape（图形）分为了两大类，一类是Polygon（多边形），一类是Ellipse（椭圆形）。

Polygon又分为两大类，一类是Rectangle（矩形），一类是Hexagon（六边形）。

Ellipse只包含它的特殊情况（长轴与短轴相等）Circle（圆形）。

Rectangle也只包含它的特殊情况（长与宽相等）Square（正方形）。

Hexagon只包含它的特殊情况（所有边相等）RegularHexagon（正六边形）。
 */
abstract public class Shape implements Comparable<Object> {
	private double perimeter, area;//周长、面积
	private String shapeType;//形状类型
	protected DecimalFormat fmt = new DecimalFormat("0.###");
	private static int sortType;//排序关键字
	public Shape(String shapeType) {
		this.shapeType = shapeType;
		sortType = 1; //默认
	}
	protected abstract void calcPerimeter();//计算周长
	protected abstract void calcArea();//计算面积
	public static void setSortType(int type) {
		if (type < 1 || type > 3) {
			return;
		}
		sortType = type;
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String toString() {
		DecimalFormat fmt = new DecimalFormat("0.##");
		for (int i = shapeType.length(); i < 36; i++) {
			shapeType += " ";
		}	
		String result = shapeType + "Perimeter = " + fmt.format(perimeter);
		result += "\tArea = " + fmt.format(area);
		return result;
	}
	public int compareTo(Object other) {
		//sortType 1:Type 2:Perimeter 3:Area
		Shape rhs = (Shape)other;
		if (sortType == 1) {
			return shapeType.compareTo(rhs.shapeType);
		}
		if (sortType == 2) {
			double gap = perimeter - rhs.perimeter;
			if (gap == 0.0) {
				return 0;
			}
			return gap > 0 ? 1 : -1;
		}
		double gap = area - rhs.area;
		if (gap == 0.0) {
			return 0;
		}
		return gap > 0 ? 1 : -1;
	}
}