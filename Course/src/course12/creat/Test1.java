package course12.creat;

/**
 * 1、定义THread类的对象，并重写run方法
 * 2、调用线程中start方法来启动该方法
 * @author asuy
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable(){
			public void run() {
				while(true)
				{
					System.out.println("t1");
					//必须使用异常sleep()毫秒为单位
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	
		Thread t2=new Thread(){
			public void run()
			{
				while(true)
				{
					System.out.println("t2");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
		while(true)
		{
			System.out.println("main");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
