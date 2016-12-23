package course12.t02;

public class TestE2 {
	 public static void main(String args[]) {
	      ClassRoom room6501 = new ClassRoom();
	      room6501.student1.start();
	      room6501.student2.start();
	      try{ Thread.sleep(1000);
	      }
	      catch(Exception exp){}
	      room6501.teacher.start();
	   }

}
