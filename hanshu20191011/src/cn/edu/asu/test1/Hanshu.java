package cn.edu.asu.test1;

/**
 * 方法(函数)
 *   从顶向下，分而治之
 *   方便我们排错和复用
 *   
 *   函数重载
 * 	
 * @author asu-student
 *
 */
public class Hanshu {
	
  public static	void test() {
	  for(int j=0;j<2;j++) {
		  for(int i=1;i<=10;i++) {
			  System.out.println("i test1="+i);
		  }
	  }
			
	}

	
	public static void main(String[] args) {
	     test();
	     
		

	}

}
