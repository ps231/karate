package karate.chops.strings;

public class StringToInteger {
	
	public static void main(String[] args) {
		int num = stringToInt("45677888");
		System.out.println(num);
	}

	private static int stringToInt(String s) {
		// TODO Auto-generated method stub
		
		int num = 0;
		
		for(int i=0;i<s.length();i++) {
			int digit = Integer.parseInt("" + s.charAt(i));
			double base = 10;
			double power = s.length() - (i+1);
			num = (int) (num +  digit * Math.pow(base, power));
		}
		return num;
	}

}
