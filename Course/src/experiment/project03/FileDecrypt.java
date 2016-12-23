package experiment.project03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDecrypt 
{
	public FileDecrypt(String fileUrl,String tempUrl,int keyLenth) throws IOException
	{
		decrypt(fileUrl,tempUrl, keyLenth);
	}
	/**
     * 解密
     * @param fileUrl 源文件
     * @param tempUrl 临时文件
     * @param ketLength 密码长度
     * @return
	 * @throws IOException 
     * @throws Exception
     */
	public static String decrypt(String fileUrl,String tempUrl,int keyLength) throws IOException
	{
		File file = new File(fileUrl);
        if (!file.exists()) {
        	System.out.println("您输入的文件不存在！！！");
            return null;
        }
        File dest = new File(tempUrl);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
         
        InputStream is = new FileInputStream(fileUrl);
        OutputStream out = new FileOutputStream(tempUrl);
         
        byte[] buffer = new byte[1024];
        byte[] buffer2=new byte[1024];
        byte bMax=(byte)255;
        long size = file.length() - keyLength;
        int mod = (int) (size%1024);
        int div = (int) (size>>10);
        int count = mod==0?div:(div+1);
        int k = 1, r;
        while ((k <= count && ( r = is.read(buffer)) > 0)) {
            if(mod != 0 && k==count) {
                r =  mod;
            }
             
            for(int i = 0;i < r;i++)
            {
                byte b=buffer[i];
                buffer2[i]=b==0?bMax:--b;
            }
            out.write(buffer2, 0, r);
            k++;
        }
        out.close();
        is.close();
        return tempUrl;
    }
  
	
}
