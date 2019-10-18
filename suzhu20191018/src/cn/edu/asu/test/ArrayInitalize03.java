package cn.edu.asu.test;

import java.util.Arrays;

/**
 * 
 * @author asuy
 *初始化：
1.动态初始化：数组定义与为数组分配空间和赋值的操作分开进行；
2.静态初始化：在定义数字的同时就为数组元素分配空间并赋值；
3.默认初始化：数组是引用类型，它的元素相当于类的成员变量，因此数组分配空间后，每个元素也被按照成员变量的规则被隐士初始化
 */
public class ArrayInitalize03 {

	public static void main(String[] args) {
		//默认初始化
		  int a [] = new int [5] ;     
	       System.out.println("" + a[3]) ;
	       for(int i:a){
	    	   System.out.print(i);
	       }
	       System.out.println();
	       System.out.println(Arrays.toString(a));

	}

}
