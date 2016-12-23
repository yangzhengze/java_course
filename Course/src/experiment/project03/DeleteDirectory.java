package experiment.project03;
import java.io.File;
class DeleteDirectory 
{	
	/**
     * 删除空目录
     * @param dir 将要删除的目录路径
	 * @return 
     */
	public  DeleteDirectory(String dir)
	{
		 boolean success = (new File(dir)).delete();
		 if (success) {
			 System.out.println("Successfully deleted empty directory: " + dir);
		 } else
		 {   
			 File f=new File(dir);
			 deleteDir(f);
		 }
		 
	}

private boolean deleteDir(File f2) {
			
	if (f2.isDirectory()) {
		String[] children = f2.list();
		for (int i=0; i<children.length; i++) {
			boolean success = deleteDir(new File(f2, children[i]));
			if (!success) {
				return false;
					 }	
				 }
			 }
		return f2.delete();
	
    }

}