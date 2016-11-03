package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	public static List<String> listFilesFrom(String path)  {
		List<String> files = new ArrayList<>();
	   
		final File folder = new File(path);
		
		for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	            files.add(path+fileEntry.getName());
	        }
	    }
		
		return files;
	}
	
}
