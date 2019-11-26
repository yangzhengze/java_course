package cn.asu.edu.test.test3;
/**
 * 父类
 * @author Administrator
 *
 */
public class People {
	
	/**
	 * 定义一个静态方法
	 */
	public static void test() {
		System.out.println("testjaagnhu");
	}
	
	public void test1() {
		System.out.println("testjaagnhu11");
	}
	
	/**
	 * 构造方法
	 */
	public People() {
		System.out.println("People.....");
		test();
		test1();
	}

}
