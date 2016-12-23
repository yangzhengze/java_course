package experiment.project03;

import java.io.IOException;
import java.util.Scanner;

public class FileMenu 
{		
	public static void main(String[]args) throws IOException
	{	
		 menu();
		 @SuppressWarnings("resource")
		 Scanner choice=new Scanner(System.in);
		 int a=choice.nextInt();
		 while(true){
		 switch(a)
		 {
		 case 1: 
			 System.out.println("please input the derectory that you want to creat(the deretory's parent must be exist):");
			 System.out.println("firstly you can input the derectory's parent  ");
			 new CreatDirectory();
		     break;

		 
		
		 case 2: 
			 System.out.println("please input the directory that you want to delete:");
			 
			 String deletedir=choice.next();
			 new DeleteDirectory(deletedir);
			 break;
		
		 case 3: 
			 System.out.println("please input the derectory that you wan to enter:");
			 String pathEnter=choice.next();
		     new EnterDirectory(pathEnter);
		     break;

		 case 4: 
			 System.out.println("Please input the directory that you want to list: ");
			 String pathList=choice.next();
			 new DiretoryList(pathList);
			 break;
			 
		 case 5: 
			 System.out.println("please input the source file path");
			 String src=choice.next();
			 System.out.println("please input the destination file path");
			 String dest=choice.next();
			 new FileCopy(src,dest);
			 break;
			 
		 case 6: 
			 System.out.println("please input the source diretory path");
			 String srcDir=choice.next();
			 System.out.println("please input the destination diretory path");
			 String destDir=choice.next();
			 new DiretoryCopy(srcDir,destDir);
		
		 case 7: 
			 System.out.println("please input the file's path that you want to encrypt:");
			 String fileUrl=choice.next();
			 System.out.println("please input the key");
			 String key=choice.next();
			// new FileEncrypt(fileUrl,key);
			try {
				new FileDesEncrypt().DesEncrypt(fileUrl, key);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 break;
			 
		 case 8:
			 System.out.println("please input the file's path that you want to decrypt:");
			 String DecryptUrl=choice.next();
			 System.out.println("please input the file's path that you want to sava(must has the filename extension  ):");
			 String tempUrl=choice.next();
			 System.out.println("please input the key");
			 String keys=choice.next();
			// new FileDecrypt(DecryptUrl,tempUrl,keys.length());
			 try {
				new FileDesEncrypt().DesDecrypt(DecryptUrl, tempUrl, keys);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			 break;
		 case 0: 
			 //System.exit(0);
			 menu();
		     break;
		 default:
			 System.out.println("erro:please enter  the choice");
			 break;
	     }
		 a=choice.nextInt();
     }
	}
public static void menu()
{
	 System.out.println("Please Choose what to do:");
	 System.out.println("'1':Create a directory");
	 System.out.println("'2':Delete a directory");
	 System.out.println("'3':Enter a directory");
	 System.out.println("'4':List a directory");
	 System.out.println("'5':Copy a file");
	 System.out.println("'6':Copy a directory");
	 System.out.println("'7':Encrypt a file");
	 System.out.println("'8':Decrypt a file");
	 System.out.println("'0':Exit");
	}
	
}
