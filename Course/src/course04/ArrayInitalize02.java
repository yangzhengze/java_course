package course04;

import java.util.Arrays;

/**
 * 
 * @author asuy
 *初始化：
1.动态初始化：数组定义与为数组分配空间和赋值的操作分开进行；
2.静态初始化：在定义数字的同时就为数组元素分配空间并赋值；
3.默认初始化：数组是引用类型，它的元素相当于类的成员变量，因此数组分配空间后，每个元素也被按照成员变量的规则被隐士初始化
 */
public class ArrayInitalize02 {
   
	public static void main(String[] args) {
		/**
		 * 数组静态初始化
		 */
	    int [] arr=new int[]{8,2,1,9,7};
	    int [] index=new int[]{2,0,4,1,1,4,3,2,2,1,0};
	    String tel="";
	    for(int i:index){
	    	tel+=arr[i];
	    }
       System.out.println("我的联系方式为："+tel);
       
       int a=5,b=4;
       int temp;
       temp=a;
       a=b;
       b=temp;
       System.out.print("a="+a+"\n");
       System.out.print("b="+b+"\n");
       int a1=5,b1=4;//加减、乘除
       b1=a1*b1;
       a1=b1/a1;
       b1=b1/a1;
       System.out.print("a1="+a1+"\n");
       System.out.print("b1="+b1+"\n");
       int a2=5,b2=4;//异或
       a2=a2^b2;
       b2=a2^b2;
       a2=a2^b2;
       System.out.print("a2="+a2+"\n");
       System.out.print("b2="+b2+"\n");
       
    
	}

}
