package cn.asu.edu.test.test2;

public class Test {

	public static void main(String[] args) {
	
		/**
		 * 创建对象
		 */
		BIM asuy=new BIM();
		    asuy.setAge(20);
		    asuy.setHeight(1.70);
		    asuy.setWeight(60);
		    asuy.setName("安顺学院");
		    asuy.getBMI();
		    
		   BIM asul=new BIM();
		    asul.setAge(20);
		    asul.setHeight(1.70);
		    asul.setWeight(60);
		    asul.setName("安顺学院");
		    asul.address="安顺市西秀区";
		   // asul.setAddress("安顺市西秀区");
		    asul.getBMI();    
		
		

	}

}
