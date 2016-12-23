package course09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferInputFile {
    //读取文件
	public static String read(String filename) throws IOException{
		 
		BufferedReader br=new BufferedReader(new FileReader(filename));
		    String s;  
		    //StringBuilder 不是线程安全的，执行速度方面的比较：StringBuilder >  StringBuffer  >  String
		    StringBuilder sb=new StringBuilder();
		    //StringBuffer //多线程安全的，
	       // StringBuffer sb = new StringBuffer();  
	        while ((s = br.readLine()) != null) {  
	            sb.append(s + "\n");  
	        }  
	        br.close();  
	        return sb.toString();  
	}
	public static void main(String[] args) throws IOException {
		
         System.out.print(read("E:/files/create.txt"));
	}

}
