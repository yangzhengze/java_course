package course06;

class University {
	 void enterRule(double math,double english,double chinese) {
	        double total=math+english+chinese;
	        if(total>=200) 
	           System.out.println("考分"+total+"达到大学最低录取线");
	        else
	           System.out.println("考分"+total+"未达到大学最低录取线");
	    }
}
class ImportantUniversity extends University{
    void enterRule(double math,double english,double chinese) {
        double total=math+english+chinese;
        if(total>=245)  
           System.out.println("考分"+total+"达到重点大学最低录取线");
        else
           System.out.println("考分"+total+"未达到重点大学最低录取线");
    }
}

 public class Example6_2 {
	 public static void main(String args[]) {
	       double math=64,english=76.5,chinese=66;
	       ImportantUniversity univer = new  ImportantUniversity();
	       univer.enterRule(math,english,chinese); //调用重写的方法
	       math=89;
	       english=80;
	       chinese=86;
	       univer = new  ImportantUniversity();
	       univer.enterRule(math,english,chinese); //调用重写的方法
	    }
	
	
}