package course12.t02;

public class ClassRoom implements Runnable {
	 Thread  student1,student2,teacher;  
	   ClassRoom() {
	       teacher = new Thread(this); 
	       student1 = new Thread(this); 
	       student2 = new Thread(this); 
	       teacher.setName("王教授");
	       student1.setName("张三");
	       student2.setName("李四");
	   } 
	   public void run(){     
	      if(student1==Thread.currentThread()) {
	    	  
	         try{  System.out.println(student1.getName()+"正在睡觉，不听课");
	               Thread.sleep(1000*60*10);
	         }
	         catch(InterruptedException e) {
	              System.out.println(student1.getName()+"被老师叫醒了");
	         }
	         System.out.println(student1.getName()+"开始听课");
	          student2.interrupt();           //吵醒student2
	       }
	      else if(student2==Thread.currentThread()) {
	         try{  System.out.println(student2.getName()+"正在睡觉，不听课");
	               Thread.sleep(1000*60*60);
	         }
	         catch(InterruptedException e) {
	              System.out.println(student2.getName()+"被张三叫醒了");
	         }
	         System.out.println(student2.getName()+"开始听课");
	       }
	      else if(teacher==Thread.currentThread())  {
	         for(int i=1;i<=3;i++) {
	            System.out.println("上课!");
	            try{ 
	            	Thread.sleep(500);
	            }
	            catch(InterruptedException e){} 
	         }
	         student1.interrupt();           //吵醒student1
	      }
	   }

}
