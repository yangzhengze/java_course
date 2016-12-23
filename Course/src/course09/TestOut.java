package course09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * 从键盘输入字母，保存到文件中
 * @author asuy
 *
 */
public class TestOut {

	public static void main(String[] args) {
	    //创建文件
	    File f=new File("D:/copy/create1.txt"); 
	    try {
	    	//正则表达式
	    	String regex="[a-zA-Z]+";
	    	//从键盘输入
			Scanner in=new Scanner(System.in);
			System.out.println("请输入字母：");
			String str=in.nextLine();
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			if(str.matches(regex)){
				writer.write(str);
				System.out.println("写入成功！");
			}else {
				System.out.println("你输入的不是全字母字符！");
			
			}
			writer.close();
			
		} catch (Exception e) {
		   e.printStackTrace();
		}

	}

}
