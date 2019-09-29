/**
 * 包名
 */
package cn.edu.asu.sanjiaoxing;
/**
 * 第三章选择结构
 *	if(){
 *   }else{
 *   }
 *   
 *   if(){
 *   }else if{
 *   ...
 *   }else{
 *   }
 *   
 *   switch(){
 *   }
 *   
 */
import java.util.Scanner;

/**、
 *定义一个新的类
 * @author asu-student
 * 
 * 计算机三角形的面积
 * 	1.获取三角形的边长(bian1,bian2,bian3)
 *  2.判断是否构成三角形
 * 		 2.1.如果构成三角形
 * 				(bian1+bian2)>bian3 && (bian1-bian2)<bian3
 *  		2.2.计算三角形面积
 *					海伦公式
 *	·					p=(bian1+bian2+bian3)/2
 *               s=^p*(p-bian1)*(p-bian2)*(p-bian3)
 */
public class JXSanJiao {
     //定义变量
	  double bian1,bian2,bian3,mainji;
     
	  public double mianji() {
		 //输入边长
		  Scanner input =new Scanner(System.in);
		  System.out.println("请输入三条边：");
		    bian1=input.nextDouble();
		    bian2=input.nextDouble();
		    bian3=input.nextDouble();    		  
		    //判读是否组成三角形
		    /**表达式：
		     * 	  基本四则运算符，
		     *    逻辑 && || ！
		     * a+b=c
		     * a+m>c
		     */
		    	if((bian1+bian2>bian3)&&(bian1-bian2<bian3)) {
		    		//计算面积
		    		System.out.println("能够构成三角形");
		    		//海伦公式
		    			double p=(bian1+bian2+bian3)/2;
		    			mainji=Math.sqrt(p*(p-bian1)*(p-bian2)*(p-bian3));
		    			System.out.println("面积="+mainji);
		    		
		    	}else {
		    		System.out.println("不能构成三角形");
		    	}
		    		
		    
		  return 1.0;
	  }
	  
	 /**
	  * 
	  * 58
	  * 输入成绩判断等级
	  * 	90-100 优
	  *     80-90 良
	  *     70-80 中
	  *     60-70 及格
	  *     -60 不及格
	  *     if(>=60&&<70){
	  *     	 System.out.println("及格");
	  *     }
	  * @param args
	  */
	  
	 public void chengji() {
		 int score=90;
		 switch (score) {
			case 6:
				
				break;
	
			default:
				break;
			} 
	  }

	public static void main(String[] args) {
		  
		  //定义一个类模板
		  JXSanJiao js=new JXSanJiao();
		  js.mianji();
		 
	

		  
	}
	  
	  

}
