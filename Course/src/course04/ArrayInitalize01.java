package course04;

import java.util.Arrays;
/**
 * java的初始化和输出
 * @author asuy
 *
 *
 * 一维数组的声明方式：
   type var[]; 或type[] var;
           声明数组时不能指定其长度（数组中元素的个数），
  Java中使用关键字new创建数组对象，格式为：
           数组名 = new 数组元素的类型 [数组元素的个数]
   创建数组
   
Java语言使用new操作符来创建数组，语法如下：
arrayRefVar = new dataType[arraySize];
上面的语法语句做了两件事：
一、使用dataType[arraySize]创建了一个数组。
二、把新创建的数组的引用赋值给变量 arrayRefVar。
     
 初始化：
1.动态初始化：数组定义与为数组分配空间和赋值的操作分开进行；
2.静态初始化：在定义数字的同时就为数组元素分配空间并赋值；
3.默认初始化：数组是引用类型，它的元素相当于类的成员变量，因此数组分配空间后，每个元素也被按照成员变量的规则被隐士初始化
 */
public class ArrayInitalize01 {
  /**
   * 
   * @param args
   */
	public static void main(String[] args) {
	      
		/**
		 * 动态
		 */
          int [] s;
          s=new int [5];
          int i;
          for( i=0;i<5;i++){
        	  s [i]=i;
          }
    	  System.out.println(" 传统的方法----------");
          for( i=0;i<5;i++){
        	 // s [i]=i;
        	  System.out.println(" "+s[i]);
          }
          System.out.println("a数组的长度 ="+s.length);
          System.out.println(" 遍历的方法----------");
          
          for( int j:s){//int j 是“声明循环变量”，必须是声明
        	  System.out.println(" "+j);  
          }
          System.out.println(" toString的方法----------");
          System.out.println(Arrays.toString( s));
	}

}
