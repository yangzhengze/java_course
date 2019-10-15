package cn.edu.asu.test;

/**
 * 方法(函数)
 *   从顶向下，分而治之
 *   方便我们排错和复用
 *   
 *   函数重载
 *      函数名称相同，参数列表不同
 *      不能以返回值来区分
 *      
 *    局部和全局变量（变量的生命周期）
 *    	局部变量：定义在函数内部的变量
 *    		如果在函数内部，局部变量覆盖全局变量（优先权）
 *          生命周期只是在函数内部(随着函数销毁而销毁)
 *   
 * 	
 * @author asu-student
 *
 */
public class Hanshu {
	//全局变量
	int a=10;
	static int d=10;
	static double sum=0;
	
  public static void add(int a,int b) {
	  int i=0;
	 System.out.println("d="+d);
	 System.out.println(a+b);
			
	}
  
  public static	double add(double a,double b) {
		double sum=a+b;
		 System.out.println("d="+d);
		 return sum;
		}

	
	public static void main(String[] args) {
	   System.out.println(add(2.5,3)) ;
	    // add(9);
	     
		

	}

}
