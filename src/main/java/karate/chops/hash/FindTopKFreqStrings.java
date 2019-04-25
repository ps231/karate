package karate.chops.hash;

import java.util.*;

public class FindTopKFreqStrings {

    public static void main(String... strings) {
        String[] inputArray = new String[]{"a", "b", "a", "c", "c", "c", "d", "d", "e", "d", "d"};
        List<String> input = Arrays.asList(inputArray);
        findTopKFreqString(input, 2).stream().forEach(System.out::println);
        System.out.println("--");
        findTopKFreqString(input, 3).stream().forEach(System.out::println);
        System.out.println("--");
        findTopKFreqString(input, 25).stream().forEach(System.out::println);
        System.out.println("--");
    }

    private static List<String> findTopKFreqString(List<String> input, int k) {
        Map<String, Temp> freqMap = new HashMap<>();

        for (String s : input) {
            if (freqMap.containsKey(s)) {
                freqMap.put(s, new Temp(s, freqMap.get(s).freq + 1));
            } else {
                freqMap.put(s, new Temp(s, 1));
            }
        }

        PriorityQueue<Temp> minHeap = new PriorityQueue<>();

        for (Map.Entry<String, Temp> e : freqMap.entrySet()) {
            if (minHeap.size() == k) {
                if (minHeap.peek().freq < e.getValue().freq) {
                    minHeap.poll();
                    minHeap.offer(e.getValue());
                }
            } else {
                minHeap.offer(e.getValue());
            }
        }

        List<String> freqStringResults = new ArrayList<>();
        while (!minHeap.isEmpty())
            freqStringResults.add(minHeap.poll().s);

        return freqStringResults;
    }
}

class Temp implements Comparable<Temp> {
    String s;
    int freq;

    Temp(String s, int freq) {
        this.s = s;
        this.freq = freq;
    }

    public int compareTo(Temp t) {
        return Integer.compare(this.freq, t.freq);
    }
}