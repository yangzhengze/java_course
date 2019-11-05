package cn.asu.edu.test;

/**
 * 类
 * 	eye(属性--数据域)
 *   say()
 *  
 * @author Administrator
 *
 */
public class People {
	private  int leg=2;
	
	
	/**
	 * 
	 * 如果自己定义构造函数，必须显示申明默认构造函数
	 */
      People(){
		  
	  }
	
	  
      People(int leg,int eye){
		  this.eye=eye;
		  this.leg=leg;
	  }
	
    public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}
	private  int eye=2;
	public void say(String s) {
		System.out.println(s);
	}

	
	public void run(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		
//		System.out.println(eye);
//		say("北京");
//		run("北京");
//	People()默认构造函数
		
		People wangyuneng=new People();
		  wangyuneng.eye=2;
		  System.out.println(wangyuneng.eye);
		  wangyuneng.say("guiyang");
		  wangyuneng.run("安顺学院");
		  
		  People yangdan=new People();
		  yangdan.eye=0;
		  System.out.println(yangdan.eye);
		  yangdan.say("zuiyi");
		  yangdan.run("beijing");
		  
		

	}
	
	

}
