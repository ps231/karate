package karate.chops.strings;

public class DecodeAtIndex {
	
	public static void main(String[] args) {
//		System.out.println(decodeAtIndex("ha22", 5));
		System.out.println(decodeAtIndex("y959q969u3hb22odq595",222280369));
	}
public static String decodeAtIndex(String s, int k) {
        
        if(s==null || s.length()<2 || k < 1)
            throw new IllegalArgumentException("invalid input");
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) {
                String sub = sb.substring(0, sb.length());
                for(int j=1;j<Integer.parseInt(""+s.charAt(i));j++)
                    sb.append(sub);
            } else {
                sb.append(s.charAt(i));
            }
            if (sb.length() >= k)
                return "" + sb.charAt(k-1);
//            else {
//                k = k-sb.length();
//                sb.setLength(0);
//            }
        }
        return "" + sb.charAt(k-1);
        
    }

}
