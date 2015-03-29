package howard.edu.sycs363.spring15.lab4;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		//Creates a new PhoneDirectory type
		PhoneDirectory prezPhoneDir = new PhoneDirectory();
		//Changes Obama's phone number to 'Confidential'
		prezPhoneDir.addorChangeEntry("Barack Obama", "Confidential");
		//Saves the string returned from looking up Barack, and then prints
		String BOnum = prezPhoneDir.lookup("Barack Obama");
		System.out.println("The number has been changed to " + BOnum);
		//Writes changes to the outfile
		prezPhoneDir.write();
		
		//Testing for new file
		PhoneDirectory hallieNumz = new PhoneDirectory("hallie_numz.txt");
		hallieNumz.addorChangeEntry("Hallie", "4041234567");
		hallieNumz.addorChangeEntry("Mom", "5647383921");
		hallieNumz.addorChangeEntry("Dad", "70398765432");
		hallieNumz.deleteEntry("Mom");
		hallieNumz.deleteEntry("Mom");
		hallieNumz.write();
		
		//More testing
		String name;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		PhoneDirectory letters = new PhoneDirectory("alphabet.txt");
		for (int i = 0; i < alphabet.length(); i++) {
			for (int j = i; j < alphabet.length(); j++) {
				name = alphabet.substring(i, j);
				Integer number = 0;
				for (int k = 0; k < name.length(); k++) {
					number += alphabet.indexOf(name.charAt(k));
				}
				letters.addorChangeEntry(name, number.toString());
			}
		}
		letters.write();
	}

}
