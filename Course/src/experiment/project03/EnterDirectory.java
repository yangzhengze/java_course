package experiment.project03;

import java.io.IOException;

class EnterDirectory {
	EnterDirectory(String path) throws IOException{
    	Runtime.getRuntime().exec("explorer.exe " + path);
    }

}
