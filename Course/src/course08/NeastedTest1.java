package course08;


class Outer {   
      int outer_x = 100;  
          class Inner{  
              public int y = 10;  
              private int z = 9;  
              int m = 5;  
              public void display(){  
              
            	  System.out.println("display outer_x:"+ outer_x);  
              
              }  
             private void display2(){  
      
            	 System.out.println("display outer_x:"+ outer_x);  
       
             }  
    }  

     void test(){  

	Inner inner = new Inner();  
	inner.display();  
	inner.display2();  
	//System.out.println("Inner y:" + y);//不能访问内部内变量  
	System.out.println("Inner y:" + inner.y);//可以访问  
	System.out.println("Inner z:" + inner.z);//可以访问  
	System.out.println("Inner m:" + inner.m);//可以访问  
	InnerTwo innerTwo = new InnerTwo();  
	innerTwo.show();  
}  
     class InnerTwo{  
    	 Inner innerx = new Inner();  
    	 public void show(){  
    		 //System.out.println(y);//不可访问Innter的y成员  
    		 //System.out.println(Inner.y);//不可直接访问Inner的任何成员和方法  
    		 innerx.display();//可以访问  
    		 innerx.display2();//可以访问  
    		 System.out.println(innerx.y);//可以访问  
    		 System.out.println(innerx.z);//可以访问  
    		 System.out.println(innerx.m);//可以访问  
    	 }  
     }  
}  
public class NeastedTest1 {

	public static void main(String[] args) {
		Outer outer = new Outer();  
		outer.test();
	}

}
