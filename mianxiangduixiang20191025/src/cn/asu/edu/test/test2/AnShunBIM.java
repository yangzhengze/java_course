package cn.asu.edu.test.test2;

public class AnShunBIM extends BIM {

	private String Pnames;
	
	@Override
	public void getBMI() {
		super.getBMI();
		System.out.println("安顺学院重载:"+Pnames);
	}
	
    

    


	public static void main(String [] args) {
		AnShunBIM test=new AnShunBIM();
	    test.setAddress("安顺学院继承");
	    test.Pnames="张三王码";
	    test.getBMI();
	}
	
}
