package course04;

/**
 * ==和equals的区别
 * 　总结来说：

　　1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；

　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

　　2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量

　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
 * @author asuy
 *
 */
public class Test3 {

	
	public static void main(String[] args) {
		Integer a=new Integer(1);
		Integer b=new Integer(1);
		System.out.println("a="+a.getClass()+"@"+a.hashCode());
		System.out.println("b="+b.getClass()+"@"+b.hashCode());
		System.out.println(a==b);
		Integer c=new Integer(1);
		Integer d=1;
		System.out.println("c="+c.getClass()+"@"+c.hashCode());
		System.out.println("d="+d.getClass()+"@"+d.hashCode());
		System.out.println(c==d);
		Integer e=1;
		Integer f=1;
		System.out.println("334"+(e==f));
		Integer g=1;
		int h=1;
		System.out.println(g==h);
		int i=1;
		int j=1;
		System.out.println(i==j);
		System.out.println(a.equals(b));
		Integer k=null;
		System.out.println(k);
	}

}
