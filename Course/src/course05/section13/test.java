package course05.section13;

public class test{
	   public static void main(String args[]) {
		      Computer computer=new Computer();
		      int result=computer.getSum(203,178,56,2098);
		      System.out.println("1203,178,56,2098的和:"+result);
		      result=computer.getSum(66,12,5,89,2,51);
		     System.out.println("66,12,5,89,2,51的和:"+result);
		   }
}
