package chapter4exercise9;

public class String3CharMaxFilter implements Filter{
	public boolean accept(String x) {
		if (x.length() <= 3) {
			return true;
		}
		else {
			return false;
		}
	}
}
