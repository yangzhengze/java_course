package cn.asu.edu.test;

public class MeiGuo {

	public static void main(String[] args) {
		People yuanyi=new People();
		 yuanyi.setLeg(1);
		 System.out.println(yuanyi.getLeg());
		
		 
		 People luoguohua=new People(4,2);
		 System.out.println(luoguohua.getLeg());

	}

}
