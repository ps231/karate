package karate.chops.test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public static void main(final String[] args) {
		int[] A = new int[] {5,5,5,8,9,9,10,11,11};
		int lastIndex = removeDuplicates(A);
		System.out.println(lastIndex);
		System.out.println(Arrays.toString(A));
	}

	private static int removeDuplicates(int[] A) {
		int uniqueSortedIndex = -1;
		int lastVal = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i] != lastVal) {
				lastVal = A[i];
				A[++uniqueSortedIndex] = A[i];
				
			}
		}
		return uniqueSortedIndex;
	}
}
