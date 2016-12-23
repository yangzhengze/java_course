package course08;
interface TestAnoymous{
	public void out() ;
}
abstract class Person {
    public abstract void eat();
}
 
class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }
}

public class AnonymousDemo {

	public static void main(String[] args) {
		//继承的实现
		   Person p = new Child();
	        p.eat();
	        //匿名类实现抽象类
	        Person person=new Person() {
				
				@Override
				public void eat() {
					System.out.println("eat anything");
				}
			};
			person.eat();
			
			 //匿名类实现接口
			TestAnoymous testAnoymous=new TestAnoymous() {
				
				@Override
				public void out() {
				   
					System.out.println("out  anything");
				}
			};
			testAnoymous.out();
	}
   
}
