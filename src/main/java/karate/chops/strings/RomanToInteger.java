package karate.chops.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	private static Map<Character, Integer> romanMap = new HashMap<>();
	
	static {
		romanMap.put('I', 1);
		romanMap.put('X', 10);
		romanMap.put('V', 5);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
	}
	
	public static void main(String...strings) {

		System.out.println(romanToInt("VI"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("VIII"));
		System.out.println(romanToInt("CIX"));
		System.out.println(romanToInt("XL"));
		System.out.println(romanToInt("IC"));
	}

	private static int romanToInt(String roman) {
		// TODO Auto-generated method stub
		int result = 0;
		int prev = Integer.MIN_VALUE;
		
		for(int i = roman.length()-1; i>=0;i--) {
			int current = romanMap.get(roman.charAt(i));
			if(current < prev)
				result -= current;
			else
				result += current;
			prev = current;
		}
		return result;
	}

}
