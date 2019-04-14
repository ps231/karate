package karate.chops.recursion;
import java.util.*;
public class FindPalindromes {
	
	public static void main(String[]args) {
		List<List<String>>result = palindromePartitioning("0204451881");
		
		for(List<String> l : result) {
			for(String s : l) {
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
	
	public static List<List<String>> palindromePartitioning(String input) {
		List<List<String>>result = new ArrayList<List<String>>();
		helper(input, 0, new ArrayList<String>(), result);
		return result;
	}
	
	private static void helper(String input, int offset, List<String> partialPartition,List<List<String>>result ) {
		if(offset == input.length()) {
			result.add(new ArrayList<>(partialPartition));
		return;
		}
		
		for(int i =offset+1;i<=input.length();i++) {
			String prefix = input.substring(offset, i);
			if(isPalindrom(prefix)) {
				partialPartition.add(prefix);
				helper(input, i, partialPartition, result);
				partialPartition.remove(partialPartition.size()-1);
			}
		}
	}
	
	private static boolean isPalindrom(String prefix) {
		for(int i=0,j=prefix.length()-1; i<j;i++,j--) {
			if(prefix.charAt(i)!=prefix.charAt(j))
				return false;
		}
		return true;
	}

}
