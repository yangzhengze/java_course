package course12;

public class Test3 {

	public static void main(String[] args) {
		final Object lock=new Object();
		Thread t1=new Thread(){
			public void run()
			{
				synchronized(lock){
					System.out.println("t1");
					try {
						System.out.println("t1:sleeping...");
						Thread.sleep(5000);
						//System.out.println("t1:exit...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t2=new Thread(){
			public void run()
			{
				synchronized(lock){
					System.out.println("t2");
				}
			}
		};
		t2.start();
		t1.start();
		
	}

}
