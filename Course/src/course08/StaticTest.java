package course08;

/**
 * 　在静态嵌套类内部，不能访问外部类的非静态成员，
 * 这是由Java语法中"静态方法不能直接访问非静态成员"所限定。
 * 若想访问外部类的变量，必须通过其它方法解决，由于这个原因，
 * 静态嵌套类使用很少。注意，外部类访问内部类的的成员有些特别，
 * 不能直接访问，但可以通过内部类来访问，这是因为静态嵌套内的所有成员和
 * 方法默认为静态的了。同时注意，内部静态类Person只在类StaticTest 范围内可见，
 * 若在其它类中引用或初始化，均是错误的。
 * @author asuy
 *
 */
public class StaticTest {   
     	private static String name = "javaJohn";          
     	private String id = "X001";  
     	static class Person{  
     		private String address = "anshuxueyuan,anshun,China";  
     		public String mail = "josserchai@163.com";//内部类公有成员  
     		public void display(){  
     			//System.out.println(id);//不能直接访问外部类的非静态成员  
     		System.out.println(name);//只能直接访问外部类的静态成员  
     		System.out.println("Inner "+address);//访问本内部类成员。  
     		}  
     	}  

     	public void printInfo(){  
     		Person person = new Person();  
     		person.display();  
     		//System.out.println(mail);//不可访问  
     		//System.out.println(address);//不可访问  
     		System.out.println(person.address);//可以访问内部类的私有成员  
     		System.out.println(person.mail);//可以访问内部类的公有成员  

     	}  
     	public static void main(String[] args) {  
     		StaticTest staticTest = new StaticTest();  
     		staticTest.printInfo();  
     	}  
     	
}  
