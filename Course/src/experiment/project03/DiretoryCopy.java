package experiment.project03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class DiretoryCopy
{	
	public DiretoryCopy(String src,String dest) 
	{	
		
			copy(src,dest);
		
	}	
	private static void copy(String src, String des) {  
		File file1=new File(src);
		File[] fs=file1.listFiles();
		File file2=new File(des);
		if(!file2.exists()){
			file2.mkdirs();
		}
		 for (File f : fs) {
			 if(f.isFile()){
				 try {
					fileCopy(f.getPath(),des+"\\"+f.getName());
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			 }else if(f.isDirectory()){ 
				 copy(f.getPath(),des+"\\"+f.getName());  
				 
			 }
		 }
		 System.out.println();
		 System.out.println("Diretory copy succesful!");
		}
	private static void fileCopy(String src, String des) throws IOException {
		InputStream in=new FileInputStream(src);
		OutputStream out=new FileOutputStream(des);
		byte b[]=new byte[1024*1024*5];
		int len=in.read(b);
		while(len!=-1)
		{
			out.write(b, 0, len);
			len=in.read(b);
		}
		in.close();
		out.close();
	}
}

