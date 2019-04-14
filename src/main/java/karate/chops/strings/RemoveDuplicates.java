package karate.chops.strings;
import java.util.*;

public class RemoveDuplicates {
	public static void main(String...strings) {
		String unique = removeDuplicates("aaabccaabbdddedcbaaddee");
		System.out.println(unique);
		
	}
	
	private static String removeDuplicates(String s) {
		StringBuilder unique = new StringBuilder();
		Set<Character> found = new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			if(found.add(s.charAt(i)))
				unique.append(s.charAt(i));
		}
		return unique.toString();
	}
}
