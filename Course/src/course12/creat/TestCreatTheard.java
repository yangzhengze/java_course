package course12.creat;



/**
 * 创建线程的两种方法
 * 1、继承Thread 类 重写run()方法
 * 2、实现Runnable接口
 * @author asuy
 *
 */
class FirstThread extends Thread{
	private int i;

	@Override
	public void run() {
		for(;i<100;i++){
			//当线程类直接继承Thread类时，直接使用this获得当前线程
			//Thread 对象的getName()直接获得当前线程的名字
			///因此直接使用getName()直接获得当前线程的名字
			System.out.println(getName()+" "+i);
		}
	
	}
	
}
class SecondThread implements Runnable{
  private int i;
	@Override
	public void run() {

		for(;i<100;i++){
			//只能使用Thread.currentThread().getName()方法获得线程名
			
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
}
public class TestCreatTheard {

	public static void main(String[] args) {

           for(int i=0;i<100;i++){
        	   //调用Thread的currentThread()方法获取当前线程
        		System.out.println(Thread.currentThread().getName()+" "+i);
        	   if(20==i){
        		   //创建第一个线程
        		  new FirstThread().start(); 
        		   //创建第二个线程
         		  new FirstThread().start(); 
        		// new FirstThread().run();//这个方法会依次执行
        		 
        		// new FirstThread().run();  
         		     
        	   }
        	  if(30==i){
        		  SecondThread st=new SecondThread();
        		  Thread t1=new Thread(st,"线程1");
        		  Thread t2=new Thread(st,"线程2");
        		  t1.start();
        		  t2.start();
         		  //通过new Thread（target，name）方法创建新线程
         		//  new Thread(st,"新线程1").start();
         		//  new Thread(st,"新线程2").start();
        	  }
           }
	}

}
