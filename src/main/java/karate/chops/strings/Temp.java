package karate.chops.strings;

public class Temp {

	public static void main(String[] args) {
		System.out.println(printStr("this is demo string", 'i', 3));
		System.out.println(printStr("geeks for geeks", 'e', 2));
		System.out.println(printStr("abc", 'c', 1));
		System.out.println(printStr("this is demo string", 'c', 5));
	}

	private static String printStr(String s, char c, int count) {
		if (count == 0 || s == null || s.length() == 0)
			return s;
		int i = 0, cur = 0;
		while (i < s.length()) {
			if (s.charAt(i) == c) {
				cur++;
				if (cur == count) {
					if (i < s.length() - 1)
						return s.substring(i + 1, s.length());
					else
						return "";
				}
			}
			i++;
		}
		return "EMPTY STRING";
	}
}