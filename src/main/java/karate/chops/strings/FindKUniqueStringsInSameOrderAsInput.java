package karate.chops.strings;
import java.util.*;
public class FindKUniqueStringsInSameOrderAsInput {
	
	public static void main(String...strings) {
		Set<String> result = findKUniqueStrings("awaglknagawunagwkwagl", 4);
		result.stream().forEach(System.out::println);
	}
	
	private static Set<String> findKUniqueStrings(String str, int k) {
		Set<String> result = new LinkedHashSet<String>();
		Map<Character, Integer> charIndex = new HashMap<Character, Integer>();

		for(int i=0,j=0;j<str.length();j++){
			if(!charIndex.containsKey(str.charAt(j))){
				charIndex.put(str.charAt(j), j);
			} else {
				int tmp = charIndex.get(str.charAt(j)) + 1;
				while(i < tmp) {
					charIndex.remove(str.charAt(i));
					i++;
				}
				i = tmp;
				charIndex.put(str.charAt(j), j);
			}

			if(j - i + 1 == k) {
				result.add(str.substring(i, j+1));
				int tmp = charIndex.get(str.charAt(i)) + 1;
				charIndex.remove(str.charAt(i));
				i = tmp;
			}
		}
		
		return result;
	}

}
