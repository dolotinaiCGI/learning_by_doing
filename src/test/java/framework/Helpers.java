package framework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Helpers {
	
	public static ArrayList<String> getClassifiedInformation() throws IOException {
		
		// initialize a new empty ArrayList
		ArrayList<String> classifiedInfo = new ArrayList<String>();
		
		// create path to the file with classified values
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\binaries\\classified.txt";
		
		// read the file with the help of a scanner
		Scanner scanner = new Scanner(new File(filePath));
		
		// do until the file contain another line
		while (scanner.hasNextLine()){
			
			// get the value from current line
			String line = scanner.nextLine();
			
			// get the substring starting after the char: =
			String delimiter = "=";
			int positionOfDelimeter = line.lastIndexOf(delimiter);
			String classifiedItem = line.substring(positionOfDelimeter + 1);

			// write the value to the ArrayList
			classifiedInfo.add(classifiedItem);
		}
		
		scanner.close();
		
		return classifiedInfo;
	} 
}