package karate.chops.strings;

public class CountPalindromeWordsInSentence {

	public static void main(String[] args) {
		System.out.println(countPalindromWords("Madam Arora speaks malayalam"));
	}
	private static int countPalindromWords(String sentence) {
		int noOfWords = 0;
		if(sentence==null || sentence.length()==0)
			return noOfWords;
		
		String[] words = sentence.split(" ");
		for(String word : words)
			if(isPalindrome(word.toLowerCase()))
				noOfWords++;
		return noOfWords;
	}
	
	private static boolean isPalindrome(String word) {
		int i =0,j=word.length()-1;
		while(i<j) {
			if(word.charAt(i++)!=word.charAt(j--))
				return false;
		}
		return true;
	}
}
