package course06;
class Bank {
	   int savedMoney;
	   int year;
	   double interest;
	   public double computerInterest() {
	      interest=year*0.035*savedMoney;
	      System.out.printf("%d元存在银行%d年的利息:%f元\n",
	                        savedMoney,year,interest);
	      return interest;
	   }
	}
class BankOfDalian extends Bank {
	   double year;
	   public double computerInterest() {
	      super.year=(int)year;
	      double remainNumber=year-(int)year;
	      int day=(int)(remainNumber*1000);
	      interest=super.computerInterest()+day*0.00012*savedMoney;
	      System.out.printf("%d元存在大连银行%d年零%d天的利息:%f元\n",
	                         savedMoney,super.year,day,interest);
	      return interest;
	   }
}
class ConstructionBank extends Bank {
	   double year;
	   public double computerInterest() {
	      super.year=(int)year;
	      double remainNumber=year-(int)year;
	      int day=(int)(remainNumber*1000);
	      interest=super.computerInterest()+day*0.0001*savedMoney;
	      System.out.printf("%d元存在建设银行%d年零%d天的利息:%f元\n",
	                         savedMoney,super.year,day,interest);
	      return interest;
	   }
	}

public class Example6_4 {

		public static void main(String args[]) {
		      int amount=5000;
		      ConstructionBank bank1=new ConstructionBank();
		      bank1.savedMoney=amount;
		      bank1.year=5.216;
		      double interest1=bank1.computerInterest();
		      BankOfDalian bank2=new BankOfDalian();
		      bank2.savedMoney=amount;
		      bank2.year=5.216;
		      double interest2=bank2.computerInterest();
		      System.out.printf("两个银行利息相差%f\n",interest2-interest1);
		   }

	}


