package cn.edu.asu.mianji;
/**
 * 导入系统已于定义好的功能
 * 
 *  导入关键字：
 *  	import  XXX;
 */
import java.util.Scanner;

public class JSMJT {

	/**
	 * 计算圆的面积
	 * 		1.获取半径R
	 * 		2.计算 area=R*R*PI
	 *      3.输出
	 */
	public static void main(String [] args) {
		/**
		 * 先定义两个变量，并且赋值
		 * 	定义变量的目的？
		 * 		分配数据存储空间
		 */
	   //从键盘输入类类型
		Scanner intput =new Scanner(System.in);
	      System.out.println("请你输入一个圆的半径");
		 
	      double R=intput.nextDouble();
		
		double area;
		//计算面积
		area=R*R*3.1415926;
		//输出 "+"字符串连接符
		System.out.println("area="+area);

		System.out.println("结果是="+(9.5*4.5-2.5*3.)/(45.5-3.5));
	}
}
