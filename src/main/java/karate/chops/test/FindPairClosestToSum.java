package karate.chops.test;

//given a sorted array, find the pair of elements closest to the sum
public class FindPairClosestToSum {

	public static void main(String[] arsg) {
		Pair p = findClosestPair(new int[] { 10, 22, 25, 28, 30, 40 }, 54);
		System.out.println(p.x + ", " + p.y);
	}

	private static Pair findClosestPair(int[] A, int sum) {
		int closest = Integer.MAX_VALUE;
		Pair p = new Pair();
		for (int i = 0, j = A.length - 1; i < j;) {
			int currentSum = A[i] + A[j];
			if (Math.abs(sum - currentSum) < closest) {
				p.x = A[i];
				p.y = A[j];
				closest = Math.min(closest, Math.abs(sum - currentSum));
			}
			if (currentSum < sum)
				i++;
			else
				j--;
		}
		return p;
	}
}

class Pair {
	int x;
	int y;
}
