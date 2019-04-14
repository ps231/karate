package karate.chops.strings;

public class FindExpressionInAFile {
	
	public static void main(String...args) {
		String file = "hello world, how ar? fine?";
		String expr = "are you";
		boolean isFound = findExpr(file.toCharArray(), expr.toCharArray());
		System.out.println(isFound);
	}
	
	private static boolean findExpr(char[] file, char[] expr) {
		for(int i = 0;i+expr.length<file.length;i++) {
			char[] fileChunk = getChunk(file, expr.length, i);
			Result r = compare(fileChunk, expr, i);
			if(r.found)
				return r.found;
			i = r.lastIndex;
		}
		
		return false;
	}
	
	private static char[] getChunk(char[] file, int size, int index) {
		char[] chunk = new char[size];
		System.arraycopy(file, index, chunk, 0, size);
		return chunk;
	}
	
	private static Result compare(char[] file, char[] expr, int lastIndex) {
		for(int i = 0;i<expr.length;i++) {
			if(file[i] != expr[i]) {
				return new Result(false, lastIndex + i);
			}
		}
		return new Result(true, 0);
	}

}

class Result {
	boolean found;
	int lastIndex;
	
	Result(boolean f, int l){
		found = f;
		lastIndex = l;
	}
}
