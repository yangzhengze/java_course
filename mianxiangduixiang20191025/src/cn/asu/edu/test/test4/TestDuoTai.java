package cn.asu.edu.test.test4;

public class TestDuoTai {


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello TestDuotai";
	}
	
	
	public String toString2() {
		// TODO Auto-generated method stub
		return "Hello TestDuotai2222";
	}
	


	public static void main(String[] args) {
	/**
	 * 鸽子是鸟类（规定鸟类所有共同属性和行为）
	 * 鸽子有些自己的特殊属性，（有别于同类）
	 * 
	 * 
	 */
		Object test=new TestDuoTai();
		

		System.out.println(test.toString());
		/**
		 * 父类没有子类的方法
		 */
		//System.out.println(test.toString2());

	}

}
