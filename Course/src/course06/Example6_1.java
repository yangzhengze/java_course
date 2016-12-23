package course06;

class People {
	   float weight,height;
	   String name;
	   void speak(String s) {
	      System.out.println(s);
	   }
	}
class Someone extends People {
	   int number;
	   double add(double a,double b){
	      return a+b;
	   } 
	} 


	public class Example6_1 {
	   public static void main(String args[]) {
	      Someone zhangSan = new Someone();
	      zhangSan.weight=65.9f; 
	      zhangSan.height=182f;
	      zhangSan.name="张三"; 
	      zhangSan.number=201011;
	      zhangSan.speak("我是"+zhangSan.name+",我的学号:"+zhangSan.number);
	      System.out.println("我的身高:"+zhangSan.height+"cm,我的体重:"+zhangSan.weight+"kg");
	      System.out.println("我会做加法:");
	      double sum=zhangSan.add(23.5,879.987);
	      System.out.println("sum="+sum);
	   }
	}

