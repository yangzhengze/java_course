package course09.radom;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 把几个int型整数写入到一个名字为tom.dat文件中，然后按相反顺序读出这些数据。

 * @author asuy
 *
 */
public class Example10_8 {

	public static void main(String[] args) {
		 RandomAccessFile inAndOut=null;
	      int data[]={1,2,3,4,5,6,7,8,9,10};
	      try{ 
	    	  inAndOut=new RandomAccessFile("D:/copy/tom.dat","rw");
	           for(int i=0;i<data.length;i++) {
	              inAndOut.writeInt(data[i]);
	           } 
	           for(long i=data.length-1;i>=0;i--) { //一个int型数据占4个字节，inAndOut从
	              inAndOut.seek(i*4);          //文件的第36个字节读取最后面的一个整数，
	              System.out.printf("\t%d",inAndOut.readInt()); //每隔4个字节往前读取一个整数
	           }
	           inAndOut.close();
	      }
	      catch(IOException e){
	    	  e.printStackTrace();
	      } 

	}

}
