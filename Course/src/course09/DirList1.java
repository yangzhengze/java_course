package course09;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList1 {

	public static void main(String[] args) {
		File path=new File(".");
		String[] list;
		String[] list2;
		   list=path.list();
			list2=path.list(new FilenameFilter() {
				
				private Pattern pattern=Pattern.compile(".git");
				
				@Override
				public boolean accept(File dir, String name) {
				
					return pattern.matcher(name).matches();
				}
			});
		
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem:list){
			System.out.println(dirItem);
		}
		System.out.println("-----------");
		Arrays.sort(list2,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem2:list2){
			System.out.println(dirItem2);
		}
	}

}
