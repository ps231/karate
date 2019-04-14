package karate.chops.strings;

public class RunLengthEncoding {
	public static void main(String[] args) {
		System.out.println("Encoded : " + encode("aaaabcccaa"));
		System.out.println("Decoded : " + decode("3e4f2e"));
	}

	public static String encode(String s) {

		if (s == null || s.length() == 0)
			return null;

		int repitition = 1;
		StringBuilder encodedStr = new StringBuilder();
		int i = 0;

		for (; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				repitition++;
				continue;
			}
			encodedStr.append(repitition);
			encodedStr.append(s.charAt(i));
			repitition = 1;

		}
		encodedStr.append(repitition);
		encodedStr.append(s.charAt(i));
		return encodedStr.toString();
	}

	public static String decode(String s) {

		StringBuilder decodedStr = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			int count = Integer.parseInt("" + s.charAt(i));
			for (int j = 0; j < count; j++) {
				decodedStr.append(s.charAt(i + 1));
			}
			i = i + 1;
		}
		return decodedStr.toString();
	}

}
