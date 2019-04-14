package karate.chops.test;

import java.util.*;

public class FindAllPrimesUptoANumber {

	public static void main(String[] args) {
//		getAllPrimes(3).stream().forEach(System.out::println);
//		getAllPrimes(2).stream().forEach(System.out::println);
//		getAllPrimes(1).stream().forEach(System.out::println);
		getAllPrimes(50).stream().forEach(System.out::println);
	}

	private static List<Integer> getAllPrimes(int limit) {
		if (limit < 2)
			return new ArrayList<Integer>();

		List<Integer> primes = new ArrayList<Integer>();
		boolean isPrime = true;
		for (int i = 2; i <= limit; i++) {
			for (int j = 0; j < primes.size(); j++) {
				if (i % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primes.add(i);
			isPrime = true; 
		}
		return primes;
	}

}
