package course05;

public class TestConstructor {
     int  x,y;
      TestConstructor(int a,int b) {
		x=a;
		y=b;
		
	}
      void f(){
    	  System.out.println("x="+x);
    	  System.out.println("y="+y);
      }
	public static void main(String[] args) {

		TestConstructor t1=new TestConstructor(1, 2);
		t1.f();
		TestConstructor t2=new TestConstructor(3, 4);
		t2.f();
		//下面这种方式可以吗？
		//TestConstructor t3=new TestConstructor();

	}

}
