package Orggymconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PathHelper {
	
	 static Properties p = new Properties();
	static {
		
		File f = new File(".");
		String filepath = f.getAbsolutePath();
		String mainpath = filepath.substring(0, filepath.length()-1)+"src\\Orggymconfig\\db.properties";
//		System.out.println(mainpath);
		
		FileInputStream fin;
		try {
			fin = new FileInputStream(mainpath);
			p.load(fin);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
