package cn.asu.edu.test.test3;

public class JangHua extends People{
	
	/**
	 * 定义一个静态方法
	 */
	
	public static void test() {
		System.out.println("testjaagnhu--zilei");
	}
	
	@Override
	public  void test1() {
		System.out.println("testjaagnhu--zilei11");
	}
	
	public JangHua() {
		/**
		 * super()
		 */
		super();
		System.out.println("Janghua");
		
		test();
		test1();
	}

}
