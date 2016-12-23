package course06;

/**
 * final 关键字：对于类是不能继承（不能有子类）
 * 对于方法是不能重写
 * 对于变量是在运行期间不能够有改变它的值（常量），也必须初始化
 * @author asuy
 *
 */
class V {
	  final double PI=3.1415926;// PI是常量
	  public double getArea(final double r) {
	     return PI*r*r;
	  }
	  public final void speak() {
	     System.out.println("您好，How's everything here ?");
	  } 
	}
	public class Example6_5 {
	   public static void main(String args[]) {
	      V a=new V();
	      System.out.println("面积："+a.getArea(100));
	      a.speak();     
	   }
	}
