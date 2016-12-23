package experiment.project03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class FileCopy {
	public FileCopy(String src,String dest) throws IOException
	{
		InputStream in=new FileInputStream(src);
		OutputStream out=new FileOutputStream(dest);
		byte b[]=new byte[1024*1024*5];
		int len=in.read(b);
		while(len!=-1)
		{
			out.write(b, 0, len);
			len=in.read(b);
		}
		in.close();
		out.close();
		System.out.println("copy successful!");
	}
	

}
