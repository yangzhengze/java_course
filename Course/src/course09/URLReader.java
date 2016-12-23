package course09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
		URL asu = new URL("http://www.asu.edu.cn/");
		BufferedReader in = new BufferedReader(new InputStreamReader(asu.openStream(),"GBk"));
		String inputLine;
		while ((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
		}
	    		
		in.close();
  } 
 }
