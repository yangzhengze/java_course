package course12.creat;

public class Testt {

	public static void main(String[] args) {
		Thread t=new Thread(){
			@Override
			public void run() {
	     // System.out.print(Thread.currentThread().getName());
				pong();
			}
		};
		    t.start();
	      //t.run();
	       System.out.print("ping");
	}
	  static void pong() {

	        System.out.print("pong");
	  }

}
