package asu.test2;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Shape[] shapes = { new Square(2), 
				           new Ellipse(2, 1), 
				           new Circle(2), 
				           new Rectangle(1, 2), 
				           new Hexagon(), 
				           new Rectangle(2, 3), 
				           new Circle(1), 
				           new RegularHexagon(1),
				         };
		System.out.println("Before Sorting:");
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		Shape.setSortType(1);
		Sorting.selectionSort(shapes);
		System.out.println("\nAfter Sorting: (By Type)");
		for (Shape shape : shapes) System.out.println(shape);
		
		Shape.setSortType(2);
		Sorting.insertionSort( shapes);
		System.out.println("\nAfter Sorting: (By Perimeter)");
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		
		Shape.setSortType(3);
		Arrays.sort(shapes);
		System.out.println("\nAfter Sorting: (By Area)");
		for (Shape shape : shapes) System.out.println(shape);
		
	}
}