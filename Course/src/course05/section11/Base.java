package course05.section11;

public class Base {

	     private String isbn;
	    protected double price;
	    
	    //默认构造函数
	    public Base() {

	    }

	    //构造函数,如果只定义带参数的构造函数而不定义默认构造函数，那么Base的子类必须定义显式构造函数
	    //Implicit super constructor Base() is undefined for default constructor. Must define an explicit 

	    public Base(String isbn, double price) {
	        this.isbn = isbn;
	        this.price = price;
	    }
	    
         protected void f(){
        	 System.out.println("this is protected");
         }
         private void gp(){
        	 System.out.println("this is private");
         }
	    public String getIsbn() {
	        return isbn;
	    }
	    public void setIsbn(String isbn) {
	        this.isbn = isbn;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
}
