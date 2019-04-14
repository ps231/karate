package karate.chops.strings;
import java.util.*;
public class FindLongestSubarrayLengthWithDistinctEntries {
	public static void main(String[] arsg) {
		List<Character>A = new ArrayList<Character>();
		A.add('f');
		A.add('s');
		A.add('f');
		A.add('e');
		A.add('t');
		A.add('w');
		A.add('e');
		A.add('n');
		A.add('w');
		A.add('e');
		A.add('x');
		A.add('g');
		A.add('h');
		
		System.out.println(findDistinctLongest(A));
		
	}
	private static int findDistinctLongest(List<Character>A) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int max = Integer.MIN_VALUE;
		int lastIdx = 0;
		
		for(int i=0;i<A.size();i++) {
			if(charMap.containsKey(A.get(i))) {
				max = Math.max(max, i-lastIdx);
				lastIdx = charMap.get(A.get(i)) + 1;
				charMap.put(A.get(i), i);
			} else {
				charMap.put(A.get(i), i);
			}
		}
		
		System.out.println(lastIdx);
		
		return Math.max(max, A.size()-1-lastIdx);
	}

}
