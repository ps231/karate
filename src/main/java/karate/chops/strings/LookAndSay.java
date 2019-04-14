package karate.chops.strings;

public class LookAndSay {
	
	public static void main(String... args) {
		String num = lookAndSay(8);
		System.out.println(num);
	}

	private static String lookAndSay(int count) {
		// TODO Auto-generated method stub 
		String seq = null;
		for(int i = 0; i<count; i++) {
			System.out.println(seq + " " + i);
			seq = calculateNext(seq);
		}
		
		
		
		
		return seq;
	}

	private static String calculateNext(String seq) {
		// TODO Auto-generated method stub
		
		if(seq == null)
			return "1";
		
		StringBuilder newSeq = new StringBuilder();
		for(int i = 0; i<seq.length(); i++) {
			char num = seq.charAt(i);
			int freq = 1;
			
			while (i < seq.length()-1) {
				if(seq.charAt(i) == seq.charAt(i+1)) {
					freq++;
					i++;
				} else
					break;
			}
			newSeq.append(""+freq+num);
		}
		
		return newSeq.toString();
	}

}
