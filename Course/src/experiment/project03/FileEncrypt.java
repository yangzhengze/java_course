package experiment.project03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileEncrypt 
{	
	public FileEncrypt(String fileUrl,String key) throws IOException
	{	
		
		// System.out.println("加密中测试");
		/**
	     *对文件file进行加密
	     * @param fileUrl 文件路径
	     * @param key 密码
	     * @throws Exception
	     */
		 File file = new File(fileUrl);
	        String path = file.getPath();
	      //  System.out.println("加密中测试22222"+file.exists());  
	        if(!file.exists()){
	        	 System.out.println("您输入的文件不存在！！！请重新输入选项"); 
	        	 FileMenu.menu();
	        	 return ;
	        }
	        int index = path.lastIndexOf("\\");
	        String destFile = path.substring(0, index)+"\\"+"abc";
	        File dest = new File(destFile);
	        InputStream in = new FileInputStream(fileUrl);
	        OutputStream out = new FileOutputStream(destFile);
	        byte[] buffer = new byte[1024];
	        int r;
	        byte[] buffer2=new byte[1024];
	        while (( r= in.read(buffer)) > 0) {
	                for(int i=0;i<r;i++)
	                {
	                    byte b=buffer[i];
	                    buffer2[i]=b==255?0:++b;
	                }
	                out.write(buffer2, 0, r);
	                out.flush();
	        }
	        in.close();
	        out.close();
	        file.delete();
	        dest.renameTo(new File(fileUrl));
	       
	        appendMethodA(fileUrl, key);
	        System.out.println("加密成功!");
	    }

private void appendMethodA(String fileName, String content)
{
		// TODO Auto-generated method stub
		try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移动到文件尾
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}     



