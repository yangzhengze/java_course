package course08;

public class TestException1 {

	public static void main(String[] args) {
	    int a=6;
	    int b=0;
	//    System.out.println("a/b="+a/b);
	    try {
	    	 // 通过throw语句抛出异常  
	    	//允许忽略不可查的RuntimeException和Error。
	    	// if (b == 0) throw new ArithmeticException(); 
			System.out.println("a/b="+a/b);
		} catch (ArithmeticException e) {
			System.out.println("程序出现异常，变量b不能为0。");
		}
	    System.out.println("程序1正常结束。");  
	    int[] intArray = new int[3];  
	    try {  
            for (int i = 0; i <= intArray.length; i++) {  
                intArray[i] = i;  
                System.out.println("intArray[" + i + "] = " + intArray[i]);  
                System.out.println("intArray[" + i + "]模 " + (i - 2) + "的值:  "  
                        + intArray[i] % (i - 2));  
            }  
        } catch (ArrayIndexOutOfBoundsException e) {  
            System.out.println("intArray数组下标越界异常。");  
        } catch (ArithmeticException e) {  
            System.out.println("除数为0异常。");  
        }  
        System.out.println("程序2正常结束。");  
	    
        int i = 0;  
        String greetings[] = { " Hello world !", " Hello World !! ",  
                " HELLO WORLD !!!" };  
        while (i < 4) {  
            try {  
                // 特别注意循环控制变量i的设计，避免造成无限循环  
                System.out.println(greetings[i++]);  
            } catch (ArrayIndexOutOfBoundsException e) {  
                System.out.println("数组下标越界异常"); 
              //  System.exit(1);
            } finally {  
                System.out.println("--------------------------");  
            }  
        }  
 
	}

}
