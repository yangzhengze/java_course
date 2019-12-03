package cn.asu.edu.test.test4;



public class TestNiaoLei {

	public static void main(String[] args) {
//		NiaoLei daQiang=new NiaoLei();
//		daQiang.fly();
//		daQiang=new Ji();
//		daQiang.fly();
//		daQiang=new Gezi();
//		daQiang.fly();
		
		NiaoLei daQiang1=new NiaoLei();
		NiaoLei daQiang2=new NiaoLei();
		
		System.out.println(daQiang1.equals(daQiang2));
		System.out.println(3==3);
		/**
		 * 强制类型转换，不建议大家使用
		 */
	//	Gezi test=(Gezi)new NiaoLei();
		//test.fly();
		
	
		
		
		daQiang(new NiaoLei());
	   daQiang(new Ji());
        daQiang(new Gezi());

	}
	
	public static void daQiang(NiaoLei  test) {
		test.fly();
		
		if(test instanceof Ji) {
			//Gezi test1=(Gezi)new NiaoLei();
			System.out.println("鸟类转换");
		}
	}
	

}
