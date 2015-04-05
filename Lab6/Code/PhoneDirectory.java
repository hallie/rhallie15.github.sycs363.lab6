package Code;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;;

class PhoneDirectory {
	// Creating a new hashMap
	private Map<String, String> directoryMap = new HashMap<String, String>();
	//Saves the path to the file as filePath so I don't have to re-write it
	private String filePath = System.getProperty("user.dir");
	//Sets the default file to 'infile.txt'
	private String file = "infile.txt";

	public PhoneDirectory() {
		//Opens up "infile.txt"
		File infile = new File(filePath + file);
		if (!infile.exists()) {
			try {
				infile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Scanner scan = new Scanner(infile);
			//If there is content in that file, it adds it to the hashMap
			while (scan.hasNextLine()) {
				//Takes the line, splits it at the comma, and then stores it
				String line = scan.nextLine();
				String [] namePhone = line.split(",");
				directoryMap.put(namePhone[0].trim(), namePhone[1].trim());
			}
			//Closes the scanner
			scan.close();
		}
		//Exception handling
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	//This does the same as above, but makes it so that you can change the
	//  the name of the file by passing in a string name
	public PhoneDirectory(String phoneDirectoryFile) {
		file = phoneDirectoryFile;
		File infile = new File(filePath + file);
		if (!infile.exists()) {
			try {
				infile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Scanner scan = new Scanner(infile);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String [] namePhone = line.split(",");
				directoryMap.put(namePhone[0].trim(), namePhone[1].trim());
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public String lookup(String personName) {
	    // return phone number based on name
		String phoneEntry = directoryMap.get(personName);
		return phoneEntry;
	}
	
	public void addorChangeEntry(String name, String phoneNumber) {
	    // if the name is already in the directory add it else replace existing
 		// name with the new phone Number
		directoryMap.put(name, phoneNumber);
	}
	
	public void deleteEntry(String name) {
	    // Remove entry from the phone book associate with “name”
		if (directoryMap.get(name) != null) {
			directoryMap.remove(name);
		}
		else {
			System.out.println("Nothing to remove");
		}
	}
	
	public void write() {
	    // write contents of in memory phone directory to a file
		PrintWriter outfile;
		try {
			outfile = new PrintWriter(filePath + file);
			for(String key : directoryMap.keySet()) {
				String line = key + ", " + directoryMap.get(key);
				outfile.println(line);
			}
			outfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}