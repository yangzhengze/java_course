package cn.edu.asu.test;

/**
 * 定义一个圆的类
 *   半径：R
 *   *   定义类的语法格式:
	[修饰符] class 类名 {
       	零个或多个构造器
       	零个或多个成员变量（属性）
       	零个或多个方法(方法)
	}
 * 
 * @author Administrator
 *
 */
public class Yuan {
	
	/**
	 * 构造方法
	 * 名称和类名一定相同
	 * 而且没有返回值包括void都不能要
	 * 
	 */
	Yuan() {
	}

	Yuan(double r) {
	   r=r;
	   mianJi();
	}
	//半径
	 static  double r;
   //面积
	  double mianJi(double r) {
		
		 
		double area=r*r*Math.PI;
		return area;
		
	}
	  
	  void mianJi() {
			
			 
			double area=r*r*Math.PI;
			System.out.println(area);
			
		}
		  
	   //周长
	double zhouChang(double r) {
			
		double zhouChang=2*r*Math.PI;
		return zhouChang;
			
		}
	public static void main(String [] args) {
	//	r=1.0;
	//System.out.println(mianJi(r));
		
		/**
		 * new 创建新的对象
		 *     构造方法（为了初始化对象）
		 *    =new Yuan();
		 *    
		 *    //对象anshunxuey(引用类型（存指向新建的对象的首地址）)
		 *    Yuan anshunxuey
		 *    
		 */
		Yuan anshunxuey=new Yuan();
		
		/**
		 * 
		 * .运算符（对象调用符号）
		 * 
		 */
		
		anshunxuey.r=1.0;
		
		System.out.println(anshunxuey.mianJi(anshunxuey.r));
		 
		Yuan guiYangy=new Yuan();
		guiYangy.r=2.0;
		System.out.println(guiYangy.mianJi(guiYangy.r));
		guiYangy.r=1.5;
		/**
		 * 调用static 修饰的变量或者方法，可以直接用类名.变量（方法）进行使用
		 */
		System.out.println(Yuan.r);
		
	}
	
	
}

