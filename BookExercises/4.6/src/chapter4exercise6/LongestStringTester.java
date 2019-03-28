package chapter4exercise6;

import java.util.ArrayList;
import java.util.Comparator;

public class LongestStringTester {

	public static void main(String[] args) {
		String longest;
		ArrayList<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("KissShortAcerolaHeartUnderBladeXAraragi4ever");
		listOfStrings.add("Shinobu");
		Comparator<String> compByStringLength = new comparatorByLength();
		longest = maximum(listOfStrings, compByStringLength);
		System.out.println("The Longest String Was: ");
		System.out.println(longest);
	}
	public static String maximum(ArrayList<String> a, Comparator<String> c) {
		int arraySize = a.size();
		int largestStringIndex = 0;
		for (int i = 0; i < arraySize ; i++) {
			int comparisonResult = c.compare(a.get(i), a.get(largestStringIndex));
			if (comparisonResult == -1) {
				largestStringIndex = i;
			}
		}
		return a.get(largestStringIndex);
	}
}
