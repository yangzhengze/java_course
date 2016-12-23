package course07;
/**
 * 接口的声明语法格式如下：
[访问控制符] interface 接口名称 {
        // 声明变量
        // 抽象方法
}
Interface关键字用来声明一个接口。下面是接口声明的一个简单例子。
 文件名 : NameOfInterface.java 
import java.lang.*;
//引入包

public interface NameOfInterface
{
   //任何类型 final, static 字段
   //抽象方法
}
接口有以下特性：
接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键子。
Java接口中的方法默认都是public,abstract类型的(都可省略),没有方法体,不能被实例化

Java接口中只能包含public,static,final类型的成员变量和public,abstract类型的成员方法
 * @author asuy
 *
 */
interface   Flyanimal{   
	   void fly();
	}
	class   Insect {   
	   int  legnum=6;
	}
	class  Bird {   
	  int  legnum=2;
	  void egg(){};
	}
	class Ant extends Insect implements  Flyanimal {
	   public void fly(){
	       System.out.println("Ant can  fly");
	   }
	}
	class Pigeon  extends Bird implements  Flyanimal {
	   public void fly(){
	       System.out.println("pigeon  can fly");
	   }
	   public void egg(){
	       System.out.println("pigeon  can lay  eggs ");
	   }
	}


public class ClassInterfaceDemo1 {

	public static void main(String[] args) {
		   Ant a=new Ant();
		     a.fly();
		     System.out.println("Ant's legs are"+ a.legnum);
		   Pigeon p= new Pigeon();
		    p.fly();
		     p.egg();
		     //接口回调
		     Flyanimal flyanimal;
		     flyanimal=new Ant();
		     System.out.println("这个是接口回调:");
		     flyanimal.fly();
	}

}
