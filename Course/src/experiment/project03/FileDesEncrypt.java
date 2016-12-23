package experiment.project03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.security.Key;

public class FileDesEncrypt {
	

	public  void DesEncrypt(String fileUrl, String key) throws IOException, Exception{
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
	           //使用Des加密
	            Key keys = getKey(key); //产生秘钥
	            Cipher cipher = Cipher.getInstance("DES"); 
	            // 加密模式
	            cipher.init(Cipher.ENCRYPT_MODE, keys); 
	            CipherOutputStream cos = new CipherOutputStream(out, cipher); 
	        byte[] buffer = new byte[1024];
	        int r;
	        while (( r= in.read(buffer)) >= 0) {
	                cos.write(buffer, 0, r);
	                cos.flush();
	        }
	        cos.close();
	        in.close();
	        out.close();
	        file.delete();
	        dest.renameTo(new File(fileUrl));
	        System.out.println("加密成功!");
		
	}
	public  void DesDecrypt(String fileUrl,String tempUrl, String key) throws IOException, Exception{
		  File file = new File(fileUrl);
	        if(!file.exists()){
	        	 System.out.println("您输入的文件不存在！！！请重新输入选项"); 
	        	 FileMenu.menu();
	        	 return ;
	        }
	      
	        InputStream in = new FileInputStream(fileUrl);
	        OutputStream out = new FileOutputStream(mkdirFiles(tempUrl));
	           //使用Des加密
	          Key keys = getKey(key); //产生秘钥
	          Cipher cipher = Cipher.getInstance("DES"); 
	            // 解密模式
	        cipher.init(Cipher.DECRYPT_MODE, keys); 
	        CipherOutputStream cos = new CipherOutputStream(out, cipher); 
	        byte[] buffer = new byte[1024];
	        int r;
	        while (( r= in.read(buffer)) >= 0) {
	                cos.write(buffer, 0, r);
	                cos.flush();
	        }
	         cos.close();
	         out.close();
	         in.close();
	        System.out.println("解密成功!");
		
	}

	private File mkdirFiles(String tempUrl) throws IOException {
		File file = new File(tempUrl);  
        if (!(file.getParentFile().exists())) {  
            file.getParentFile().mkdirs();  
        }  
       file.createNewFile();  
		return file;
	}
	private static Key getKey(String strKey) {
		  try { 
		        KeyGenerator generator = KeyGenerator.getInstance("DES"); 
		        generator.init(new SecureRandom(strKey.getBytes())); 
		        Key key = generator.generateKey(); 
	
		        return key;
		    } catch (Exception e) { 
		        throw new RuntimeException("Error initializing SqlMap class. Cause: " + e); 
		    } 
		
	}
}
