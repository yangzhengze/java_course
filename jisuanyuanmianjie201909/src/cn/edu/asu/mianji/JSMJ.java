/**
 * 包名:唯一限定这个类。
 * 
 * 怎么命名包名：利用我们网站的域名的反写来限定,以"."进行分割，包名必须是小写
 * 	URL:http://www.asu.edu.cn/
 * 域名：www.asu.edu.cn
 * 包的关键字：package 
 * 定义：
 * 	 package 包名(利用我们网站的域名的反写来限定,以"."进行分割，包名必须是小写)
 * 
 * 
 */
package cn.edu.asu.mianji;


/**
 * 定义一个类(一个新数据类型)
 * 		基本数据类型
 *      函数（行为）
 *      
 *      关键字：
 *      	class 
 *      定义：
 *      [权限修饰符]	class 变量名称
 *      
 *      [权限修饰符]包括：
 *      	public(公共的)，protected(保护的)，private(私有的)，default(包的权限)
 *      
 *  
 * @author asu-student
 *
 */
public class JSMJ {
	/**
	 * 计算圆的面积
	 * 		1.获取半径R
	 * 		2.计算 area=R*R*PI
	 * 
	 *  
	 *      3.输出
	 */
	public static void main(String [] args) {
		/**
		 * 先定义两个变量，并且赋值
		 * 	定义变量的目的？
		 * 		分配数据存储空间
		 */
	
		
		double R=1,area;
		//计算面积
		area=R*R*3.1415926;
		//输出 "+"字符串连接符
		System.out.println("area="+area);

		System.out.println("结果是="+(9.5*4.5-2.5*3.)/(45.5-3.5));
	}
	
	
	
	
    

}
