package course05.section13;

public class Computer {
	 public int getSum(int... x) {//x可变参数的参数代表
	      int sum=0;
	      for(int i=0;i<x.length;i++) {
	         sum=sum+x[i]; 
	      }
//	      for(int tmp:x){
//	    	sum=sum+tmp;  
//	      }
	      return sum; 
	   }
}
