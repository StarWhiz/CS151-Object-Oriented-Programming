package chapter4exercise6;

import java.util.Comparator;

public class comparatorByLength implements Comparator<String> {
	public int compare(String string1, String string2) {
		int len1 = string1.length();
		int len2 = string2.length();
		if (len2 > len1) {
			return 1;
		}
		else if (len1 == len2) {
			return 0;
		}
		else {
			return -1;
		}
	}
}
