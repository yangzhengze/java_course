package cn.edu.asu.test;
/**
 * 数组
 * 		存储同个类型的多个数据的集合
 * 
 *   定义
 *   
 * @author asu-student
 *
 */
public class ShuZu {

	public static void main(String[] args) {
		/**
		 * 定义
		 *   int [] a;
		     int b [];
		 */
		int [] a;
		int b [];
		/**
		 * java特殊定义数组
		 * 
		 * 
		 */
		  int [] d=new int [5];
		 
		/**
		 * java 不允许这样做
		 */
	//	a= {1,2,3};
		/**
		 * 初始化
		 * 
		 */
		int [] c = {1,2,3,4,5};
		
		/**
		 * int [] d数组的初始化
		 * 可以用循环来做
		 */
		for(int k=0;k<5;k++) {
			d[k]=k;	
		}
		
		/**
		 * 输出
		 */
		System.out.println(c[2]);
		for(int i=0;i<5;i++) {
			System.out.println("c["+i+"]="+c[i]);
		}
		 
		for(int j=0;j<5;j++) {
			System.out.println("d["+j+"]="+d[j]);
		}
		 
		  /**
		   * foreach
		   *    本质还是循环，简单
		   *     for(循环;;)
		   */
		  
		
		

	}

}
