package tek.capstone.guardians.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class FileUtility {
	
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException{
		
		return new FileInputStream(new File(filePath));
		
	}

}
