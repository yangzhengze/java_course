package experiment.project03;

import java.io.File;

class DiretoryList {
	DiretoryList(String path){
		//String luj=null;//路径   
	     //如果dir不以文件分隔符结尾，自动添加文件分割符
	     if(!path.endsWith(File.separator)) 
	     { 
	      path = path + File.separator; 
	      
	     }    
	     File dirFile = new File(path); 
	     //如果dir对应的文件不存在，或者不是一个文件夹则退出
	     if(!dirFile.exists() || (!dirFile.isDirectory())){ 
	      System.out.println("List失败，找不到目录"+path); 
	     // return; 
	     } 
	    
	     /* 
	     * list方法返回该目录下的所有文件（包括目录）的文件名，文件名不含路径信息
	     * 
	        String[] files = dirFile.list(); 
	      for(int i = 0; i < files.length; i++){ 
	       System.out.println(files[i]); 
	      } 
	     */ 
	    
	      //列出文件夹下所有的文件 
	     File[] files = dirFile.listFiles(); 

	     for(int i = 0; i < files.length; i++) 
	     { 
	      if(files[i].isFile()) 
	      { 
	       System.out.println(files[i].getAbsolutePath() + "是文件！");       
	      } 
	      else if (files[i].isDirectory()) 
	      { 
	       System.out.println(files[i].getAbsolutePath() + " 是目录！");    

	      } 
	     } 
	     //return luj; 
	}
			
}
