package testCases;

import java.io.File;

public class TestClass {

	public static void main(String [] args){
		
		System.out.println(System.getProperty("user.dir"));
		
		
	}
	public static String getHomeDirectory(){

	    File f= new File(System.getProperty("user.dir"));
	    do {
		        f = f.getParentFile();
		    } while (f.getParentFile() != null);
	    return f.getPath();

	} 
}
