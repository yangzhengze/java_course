package course06;
/**
 * 向上转型：子类引用的对象转换为父类类型称为向上转型。
 * 通俗地说就是是将子类对象转为父类对象。此处父类对象可以是接口

      向下转型：父类引用的对象转换为子类类型称为向下转型。

前者是一个向上转型，Animal dog 引用指向new Dog();
子类对象当成父类对象，只能调用父类的成员，
如果子类重写了父类的方法就根据这个引用
指向调用子类重写的这个方法（这个方法就是覆盖override）。
这个调用过程就称为“动态绑定”。
 * @author asuy
 *
 */
class Animal{
	public void eat(){
		System.out.println("Animal eatting....");
	}
	public static void out(){//静态方法
		System.out.println("Animal out....");
	}
}
class Bird extends Animal{
	
	public void eat(){
		System.out.println("Bird eatting....");
	}
	public static void out(){
		System.out.println("Bird out....");
	}
	public void fly(){
		System.out.println("Bird flying....");
	}
}
public class Example6_6 {

	public static void main(String[] args) {
		Animal animal=new Bird();//向上转型
		animal.eat();
		animal.out();//注意静态方法
		//animal.fly(); //父类没有创建方法

	}

}
