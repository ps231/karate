package karate.chops.test;

import java.util.ArrayList;
import java.util.List;

public class ComputePrime {

	public static void main(String[] args) {
	
		List<Integer>primes = computePrimes(50);
		primes.stream().forEach((Integer i) -> System.out.println(i));
	}
	
	
//	private static List<Integer> computePrimes(int limit) {
//		List<Integer> primes = new ArrayList<Integer>();
//		
//		if(limit >= 4) {
//			primes.add(2);
//			primes.add(3);
//		}
//			
//		for(int i = 5; i <=limit; i+=2) {
//			boolean isPrime = true;
//			for (int prime : primes) {
//				if(i % prime == 0) {
//					isPrime = false;
//					break;
//				}
//			}
//			if(isPrime)
//				primes.add(i);
//		}  
//		
//		
//		
//		return primes;
//	}
	
	private static List<Integer> computePrimes(int limit) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(limit < 2)
			return result;
		
		if(limit == 2) {
			result.add(2);
			return result;
		}
		
//		if(limit >= 3) {
			result.add(2);
			result.add(3);
//			return result;
//		}
		
		for(int i = 5 ; i <= limit;i+=2) {
			boolean isPrime = true;
			for (int prime : result) {
				if(i % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				result.add(i);
			
		}
		
		return result;
	}
}

