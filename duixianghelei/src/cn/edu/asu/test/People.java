package cn.edu.asu.test;
/**
 * 
 * @author Administrator
 *
 */
public class People {
	
	/**
	 * 定义静态变量
	 */
	static double PI=3.1415926;
	/**
	 * 眼睛  
	 *
	 */
	int eye;
	/**
	 * 腿
	 */
	int  leg;
	/**
	 * 年龄
	 */
	int  age;
	/**
	 * 性别
	 */
	char XB;
	/**
	 * 圆类的变量（对象）
	 */
	Yuan yaun;
	
	static void test() {
		System.out.println(PI);
	//System.out.println(eye);
	}
	
	public static void main(String[] args) {
		People wo=new People();
		
		System.out.println(wo.age);
		System.out.println(wo.XB);
		System.out.println(wo.yaun);
		System.out.println(wo.PI);
		System.out.println(People.PI);
		
	}

}
