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
  public static int zuiBa =1;
	/**
	 * 眼睛  
	 *
	 */
  private int eye;
	/**
	 * 腿
	 */
  protected	int  leg;
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
		System.out.println(zuiBa);
	//System.out.println(eye);
	}
	
	public static void main(String[] args) {
		//创建wo的对象，然后进行赋值
		People wo=new People();
		
		System.out.println(wo.age);
		System.out.println(wo.eye);
		System.out.println(wo.XB);
		System.out.println(wo.yaun);
		System.out.println("wo.zuiBa="+wo.zuiBa);
		wo.zuiBa=5;
		
		//创建wo的对象，然后进行赋值
		People ta=new People();
		
		System.out.println("ta.zuiBa="+ta.zuiBa);
		
	}

}
