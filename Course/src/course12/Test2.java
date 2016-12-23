package course12;

public class Test2 {
	private static int a=0;
	public  synchronized  static void inc()
	{
		a++;
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++)
					//System.out.println("------T1: "+i);
					inc();
				
			}
		};
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++)
					//System.out.println("------T2: "+i);
					inc();
			}
		};
		t1.start();
		t2.start();
		/**
		 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
		 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
		 */
		t1.join();
		t2.join();
		System.out.println(a);

	}

}
