package karate.chops.recursion;

import java.util.*;

class PermutationGenerator{
	private Map<Character, String> keypad = new HashMap<Character, String>();
	
	public static void main(String...strings) {
		PermutationGenerator g = new PermutationGenerator();
		g.generatePermutations("234");
	}
	
	private void generatePermutations(String phoneNumber) {
		List<String> combinations = new ArrayList<>();
		keypad.put('2', "abc");
		keypad.put('3', "def");
		keypad.put('4', "ghi");
		
//		permutationHelper(phoneNumber, keypad, new char[phoneNumber.length()], 0, combinations);
		combinations = letterCombinations(phoneNumber);
		combinations.stream().forEach(System.out::println);
	}

//	private void permutationHelper(String phNo, Map<Character, String> keypad, char[] temp, int level, List<String>combinations) {
//		for(int i=0;i<keypad.get(phNo.charAt(level)).length();i++){
//			temp[level] = keypad.get(phNo.charAt(level)).charAt(i);
//
//			if(level == phNo.length() - 1)
//				combinations.add(Arrays.toString(temp));
//			
//			else
//				permutationHelper(phNo, keypad, temp, level+1, combinations);
//		}
//
//		
//	}
	
//	private void permutationHelper(String phNo, Map<Character, String> keypad, char[] temp, int level, List<String>combinations) {
//		if(phNo.length() == level)
//			combinations.add(Arrays.toString(temp));
//		else {
//			
//			for(int i=0;i<keypad.get(phNo.charAt(level)).length();i++) {
//				temp[level] = keypad.get(phNo.charAt(level)).charAt(i);
//				permutationHelper(phNo, keypad, temp, level+1, combinations);
//			}
//		}
//
//		
//	}
	
public List<String> letterCombinations(String digits) {
        
        Map<Character, String> keyPad = new HashMap<Character, String>();
        keyPad.put('2', "abc");
        keyPad.put('3', "def");
        keyPad.put('4', "ghi");
        keyPad.put('5', "jkl");
        keyPad.put('6', "mno");
        keyPad.put('7', "pqrs");
        keyPad.put('8', "tuv");
        keyPad.put('9', "wxyz");
        
        List<String> combinations =  new ArrayList<String>();
        
        helper(keyPad, combinations, digits, "", 0);
        return combinations;
        
    }
    
    private void helper(Map<Character, String>keyPad, List<String> combinations, String digits, String intermediate, int level) {
        
        if(level == digits.length()) {
            combinations.add(intermediate);
            return;
        }
        
        for(int i =0; i<keyPad.get(digits.charAt(level)).length();i++){
            helper(keyPad, combinations, digits, intermediate + keyPad.get(digits.charAt(level)).charAt(i), level + 1);
        }
    }


}

