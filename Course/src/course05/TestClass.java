package course05;

public class TestClass {
     int x=10;
	static int y;
     //下面是不可以这样做的
//     int b;
//     b=12;
    static void f(){
    	 int x=5;
    	 y=x+x;
    	System.out.println("y="+y);
     }
     public static void main(String [] args){
    	 f();
     }
}
