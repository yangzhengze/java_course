package course12.t03;

public class JoinWork implements Runnable {
	   Thread shiji;
	   Thread zhuangyungong;
	   Thread guanliyuan;
	   JoinWork() {
	      shiji=new Thread(this);
	      zhuangyungong=new Thread(this);
	      guanliyuan=new Thread(this);
	   }
	   public void run() {
	      if(shiji==Thread.currentThread()) {
	          System.out.println("司机等待装运工装车");
	          try{ 
	                zhuangyungong.start();
	                zhuangyungong.join();            
	          } 
	          catch(InterruptedException e){}
	          System.out.println("司机开车走了");
	      }
	     else if(zhuangyungong==Thread.currentThread()) {
	          System.out.println("装运工等待管理员");
	          try{ 
	                guanliyuan.start();
	                guanliyuan.join();            
	          } 
	          catch(InterruptedException e){}
	          System.out.println("装运工把车装载完毕");
	      }
	      else if(guanliyuan==Thread.currentThread()) {
	          System.out.println("管理员把装车手续办好，打开仓库大门");
	      }
	   }   

}
