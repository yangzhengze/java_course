package asu.test2;

public class Sorting {
	public static void selectionSort(Comparable<Object>[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) 
				if (list[j].compareTo(list[min]) < 0) min = j;
			Comparable<Object> t = list[min];
			list[min] = list[i];
			list[i] = t;
		}
	}
	public static void insertionSort(Comparable<Object>[] list) {
		for (int i = 0; i < list.length; i++) {
			Comparable<Object> key = list[i];
			int pos = i;
			while (pos > 0 && key.compareTo(list[pos - 1]) < 0) {
				list[pos] = list[pos - 1];
				pos--;
			}
			list[pos] = key;
		}
	}
}