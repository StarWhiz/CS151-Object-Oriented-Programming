package chapter4exercise9;

import java.util.ArrayList;

public class MyFilterTester {

	public static void main(String[] args) {

		ArrayList<String> listOfStrings = new ArrayList<String>();
		ArrayList<String> filteredList = new ArrayList<String>();
		
		listOfStrings.add("KissShortAcerolaHeartUnderBladeXAraragi4ever");
		listOfStrings.add("Shinobu");
		listOfStrings.add("SawariNeko");
		listOfStrings.add("HeartUnderBlade");
		listOfStrings.add("KissShotAcerolaHeartUnderBlade");
		listOfStrings.add("Ara");
		listOfStrings.add("ka");
		listOfStrings.add("no");
		
		String3CharMaxFilter filter3Max = new String3CharMaxFilter();
		filteredList = filter(listOfStrings, filter3Max);	
		
		for (int i = 0; i < filteredList.size(); i++) {
			System.out.println(filteredList.get(i));
		}
	}
	public static ArrayList<String> filter(ArrayList<String> a, Filter f) {
		ArrayList<String> filteredList = new ArrayList<String>();
		int countAddedToNewList = 0;
		for (int i = 0; i < a.size(); i++) {
			String currentString = a.get(i);
			if(f.accept(currentString)) {
				filteredList.add(currentString);
				countAddedToNewList++;
			}
		}
		return filteredList;
	}
}
