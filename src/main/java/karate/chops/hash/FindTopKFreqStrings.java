package karate.chops.hash;

import java.util.*;

public class FindTopKFreqStrings {

	public static void main(String... strings) {
		String[] input = new String[] { "a", "b", "b", "a", "c", "c", "c", "d", "d", "e", "d" };
		findTopKFreqString(Arrays.asList(input), 2).stream().forEach(System.out::println);
		findTopKFreqString(Arrays.asList(input), 3).stream().forEach(System.out::println);
		findTopKFreqString(Arrays.asList(input), 25).stream().forEach(System.out::println);
	}

	private static List<String> findTopKFreqString(List<String> input, int k) {
		List<String> result = new ArrayList<String>();

		if (input == null || input.isEmpty() || input.size() < k)
			return result;

		Map<String, Integer> freqMap = new HashMap<String, Integer>();
		for (String s : input) {
			if (freqMap.containsKey(s)) {
				freqMap.put(s, freqMap.get(s) + 1);
			} else {
				freqMap.put(s, 1);
			}
		}

		PriorityQueue<Temp> minHeap = new PriorityQueue<Temp>(new Comparator<Temp>() {
			public int compare(Temp t1, Temp t2) {
				return Integer.compare(t1.freq, t2.freq);
			}
		});

		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() != k) {
				minHeap.offer(new Temp(entry.getKey(), entry.getValue()));
			} else {
				Temp t = minHeap.peek();
				if (entry.getValue() > t.freq) {
					minHeap.poll();
					minHeap.offer(new Temp(entry.getKey(), entry.getValue()));
				}
			}
		}

		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().s);
		}

		return result;

	}
}

class Temp {
	String s;
	int freq;

	Temp(String s, int freq) {
		this.s = s;
		this.freq = freq;
	}
}
