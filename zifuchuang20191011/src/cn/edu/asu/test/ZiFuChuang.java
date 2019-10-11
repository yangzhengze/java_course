package cn.edu.asu.test;

/**
 * 
 * 字符定义
 *   字符的编码
 *   	ASCII(1个字节8位)
 *   		a(97)
 *   		A=a-32
 *   		0(48)
 *      unicode（通用2个字节16位，很多扩展4个字节）
 *      
 *      char a='1';
 *       符号：
 *          "+"
 *      
 *      
 *      
 * @author asu-student
 *
 */
public class ZiFuChuang {

	public static void main(String[] args) {
		/**
		 * 对于整数，就是求和
		 * 1+2
		 */
		System.out.println(1+2);
		
	    /**
	     * 对于字符
	     * char a=1
	     * char b=2
	     *  a+b
	     *  如果都是整数，
	     *  	+就是算术求和
	     *  如果是字符和整数
	     *  	+：
	     *  	 整数值还是不变，但是字符的值转换成ASCII
	     *  如果是字符和字符
	     *  	+：
	     *  	 字符的值转换成ASCII,然后相加
	     */
		
		char a='1',b='a';
		System.out.println(a+b);
		
		char c=1,d='a';
		System.out.println(c+d);
		
		/**
		 * 转义字符
		 *  hello "你吃饭了没有"
		 */
		System.out.println("hello\"你吃饭了没有\"");
		
		/**
		 * 字符的比较
		 */
		
		System.out.println(a>b);
		
		/**
		 * 字符的测试
		 * char
		 * Character
		 * 输入a,输出大写字母
		 */
		char test='a';
		char test1=(char) (test-32);
		System.out.println(test1);
		char test2=Character.toUpperCase('a');
		System.out.println(test2);

	}

}
