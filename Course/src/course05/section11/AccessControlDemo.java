package course05.section11;
/**
 * 
 * @author asuy
 *
 */
public class AccessControlDemo {

	public static void main(String[] args) {
		 Base base=new Base("123-1",120.1);
		    //base.isbn=12;
	        System.out.println(base.price);
	        base.f();
	       // base.gp();       
	       A a=new A();
	       a.setX(-100);
	       a.setY(-200);
	       System.out.println(a.getXYSum());
	}

}
