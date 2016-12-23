package course06;
/**
 * 在向下转型过程中，分为两种情况：

情况一：如果父类引用的对象如果引用的是指向的子类对象，
那么在向下转型的过程中是安全的。也就是编译是不会出错误的。

情况二：如果父类引用的对象是父类本身，那么在向下转型的过程中是不安全的，
编译不会出错，但是运行时会出现java.lang.ClassCastException错误。
它可以使用instanceof来避免出错此类错误。
 * @author asuy
 *
 */
class Girl{
	 public  void smile(){

         System.out.println("girl smile()...");
      }
}
class MMGirl extends Girl{
	public void smile(){
	     System.out.println("MMirl smile sounds sweet...");
	}
    public void c(){

        System.out.println("MMirl c()...");

}
}
public class Example6_6_1 {

	public static void main(String[] args) {
	    Girl g1=new MMGirl(); //向上转型

        g1.smile();

        MMGirl mmg=(MMGirl)g1;    //向下转型,编译和运行皆不会出错

        mmg.smile();

        mmg.c();

        Girl g2=new Girl();

      MMGirl mmg1=(MMGirl)g2; //不安全的向下转型,编译无错但会运行会出错

      mmg1.smile();

      mmg1.c();

//        if(g2 instanceof MMGirl){
//
//                 MMGirl mmg1=(MMGirl)g2;
//
//                 mmg1.smile();
//
//                 mmg1.c();
//
//        }	

	}

}
/**
 * 
 * 
 * 总结：

1、父类引用可以指向子类对象，子类引用不能指向父类对象。

2、把子类对象直接赋给父类引用叫upcasting向上转型，向上转型不用强制转型。

　　 如Father father = new Son();

3、把指向子类对象的父类引用赋给子类引用叫向下转型（downcasting），要强制转型。

　　 如father就是一个指向子类对象的父类引用，把father赋给子类引用son 即Son son =（Son）father；

　　 其中father前面的（Son）必须添加，进行强制转换。

4、upcasting 会丢失子类特有的方法,但是子类overriding 父类的方法，子类方法有效

5、向上转型的作用，减少重复代码，父类为参数，调有时用子类作为参数，就是利用了向上转型。这样使代码变得简洁。体现了JAVA的抽象编程思想。
 */
