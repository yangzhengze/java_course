package cn.asu.edu.test.test2;

public class AnShunBIM extends BIM {

	private String Pnames;
	protected double address;
	
	AnShunBIM(){
		/**
		 * 子类调用父类方法或者属性的关键字
		 *      	如果它在构造方法内部，必须在第一行
		 */
		super();
		System.out.println("AnShunBIM");
		
	}
	
	/**
	 * 重写
	 * @Override 标注，主要的作用为了代码容易读
	 */
	@Override
	public void getBMI() {
		/**
		 * super
		 *      
		 */
		super.getBMI();
		System.out.println("安顺学院重载:"+Pnames);
		
	}
	


	public static void main(String [] args) {
		AnShunBIM test=new AnShunBIM();
		test.address=14.0;
	    //test.setAddress("安顺学院继承");
	    test.Pnames="张三王码";
	    test.getBMI();
	}
	
}
