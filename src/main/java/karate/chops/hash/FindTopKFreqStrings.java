package karate.chops.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindTopKFreqStrings {

    public static void main(String... strings) {
        List<String> input = Arrays.asList("a", "b", "a", "c", "c", "c", "d", "d", "e", "d", "d");
        findTopKFreqString(input, 2).stream().forEach(System.out::println);
        System.out.println("--");
        findTopKFreqString(input, 3).stream().forEach(System.out::println);
        System.out.println("--");
        findTopKFreqString(input, 25).stream().forEach(System.out::println);
        System.out.println("--");
    }

    private static List<String> findTopKFreqString(List<String> stringList, int k) {
        if (stringList == null || stringList.size() == 0)
            return new ArrayList<>();

        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : stringList) {
            if (freqMap.containsKey(s)) {
                int updatedFreq = freqMap.get(s) + 1;
                freqMap.put(s, updatedFreq);
            } else {
                freqMap.put(s, 1);
            }
        }

        PriorityQueue<Temp> minHeap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(new Temp(entry.getKey(), entry.getValue()));
            } else {
                if (minHeap.peek().freq < entry.getValue()) {
                    minHeap.poll();
                    minHeap.offer(new Temp(entry.getKey(), entry.getValue()));
                }
            }
        }

        List<String> topKFreqStrings = new ArrayList<>();
        while (!minHeap.isEmpty())
            topKFreqStrings.add(minHeap.poll().s);
        return topKFreqStrings;
    }

    private static class Temp implements Comparable<Temp> {
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
}