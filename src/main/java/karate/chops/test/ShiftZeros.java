package karate.chops.test;

import java.util.Arrays;

public class ShiftZeros {
	
	public static void main(String...strings) {
		ShiftZeros a = new ShiftZeros();
		int[] A = new int[] {1,10,20,0,59,63,0,88,0};
		a.shiftZerosLeft(A);
		Arrays.stream(A).forEach(System.out::println);
	}
	
	private void shiftZerosLeft(int[] A) {
		int last = A.length -1;
		int current = last;
		
		while(current >=0) {
			if(A[current]==0)
				current--;
			else {
				A[last] = A[current];
				last--;
				current--;
			}
		}
		
		while(last>=0)
			A[last--] = 0;
	}
}
