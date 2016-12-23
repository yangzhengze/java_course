package course04;

public class Test1 {

	static void fun(int a)
	{
		a++;
		System.out.println("fun="+a);
	}
	public static void main(String[] args) {
		int a=0;
		fun(a);
		System.out.println("main="+a);

	}

}
