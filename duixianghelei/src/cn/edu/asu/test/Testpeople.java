package cn.edu.asu.test;
/**
 * 测试权限
 * default private protected public  
 *   包的权限：default
 *   		同一个包的下面,可以随时访问,不同包需要导入包，才能够访问
 *   private :
 *   	只能自己使用
 * @author asu-student
 *
 */
public class Testpeople {

	public static void main(String[] args) {
		People pe=new People();
		//私有的，不能访问
	  //	  pe.eye=1;

	}

}
