package karate.chops.test;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAnInteger {

	public static void main(String[] args) {
		System.out.println(reverseInteger(34));
		System.out.println(reverseInteger(432));
		System.out.println(reverseInteger(-348));
		System.out.println(reverseInteger(400));
		System.out.println(reverseInteger(-2000));
	}

//	private static int reverseInteger(int number) {
//		int result = 0;
//		while (number != 0) {
//			int remainder = number % 10;
//			result = result * 10 + remainder;
//			number = number / 10;
//		}
//		return result;
//	}

	private static int reverseInteger(int number) {
		Queue<Integer> q = new LinkedList<Integer>();
		int reverse = 0;
		while (number != 0) {
			q.add(number % 10);
			number = number / 10;
		}
		while (!q.isEmpty()) {
			reverse = reverse * 10 + q.poll();
		}
		return reverse;
	}
}
