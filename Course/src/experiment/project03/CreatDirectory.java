package experiment.project03;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
/*class CreatDirectory
{	
	Scanner s=new Scanner(System.in);
	String dire=s.next();
	
	File f=new File(dire);
	File parent=f.getParentFile();
	if(parent!=null&&!parent.exists())
	{
		parent.mkdirs();
	}
	f.createNewFile();
}
*/
class CreatDirectory{
	CreatDirectory() throws IOException{
	@SuppressWarnings("resource")
	Scanner dire=new Scanner(System.in);
	//System.out.println("Enter the exist directory");
	String CurrentDirectory=dire.next();
	 File file=new File(CurrentDirectory);
	 if(file.exists())
	 {
		 System.out.println("Enter the directory name:");
		 String Name=dire.next();
		 File f = new File(CurrentDirectory+File.separator+Name) ;// ʵ����File��Ķ���
		 f.mkdir() ;
		 System.out.println("success to create!");
	 }
	 else 
		 System.out.println("the directory isn't exist!");
}

}
