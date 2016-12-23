package course09.lock;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

/**
 * Java程序让用户从键盘输入一个正整数，然后程序读取文件的内容，
 * 比如输入整数2，程序顺序读取文件中2行的内容。
 * 程序首先释放文件锁，然后读取文件内容，读取之后立刻给文件加锁，
 * 等待用户输入下一个整数。因此，在用户输入下一个整数之前，
 * 其他程序无法操作被当前用户加锁的文件。
 * 比如其他用户试图使用Windows操作系统提供“记事本”程序(Notepad.exe)
 * 无法保存被当前Java程序加锁的文件。
 * @author asuy
 *
 */
public class Example10_14 {

	public static void main(String[] args) {
		File file=new File("D:/copy/lock.txt");
	      Scanner scanner = new Scanner(System.in);
	      try{ 
	          RandomAccessFile input = new RandomAccessFile(file,"rw");
	          FileChannel channel = input.getChannel();
	          FileLock lock=channel.tryLock(); //加锁
	          System.out.println("输入要读去的行数:");
	          while(scanner.hasNextInt()){
	             int m = scanner.nextInt();
	             lock.release();                //解锁
	             for(int i=1;i<=m;i++) {
	                String str=input.readLine();
	                System.out.println(str);
	             }
	             lock=channel.tryLock(); //加锁
	             System.out.println("输入要读去的行数:");
	          }
	      }
	      catch(IOException event) {
	          System.out.println(event);
	      }

	}

}
