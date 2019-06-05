package karate.chops.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i2, i1);
        }
    });

    public void add(int number) {
        minHeap.offer(number);
        if (minHeap.size() - maxHeap.size() > 1)
            maxHeap.offer(minHeap.poll());
    }

    public double getMedian() {
        if (minHeap.isEmpty())
            throw new IllegalStateException("median cannot be determined");
        if (minHeap.size() - maxHeap.size() == 1)
            return minHeap.peek();
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        throw new IllegalStateException("invalid state");
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.add(100);
        mf.add(90);
        mf.add(105);
        mf.add(80);
        mf.add(115);
        System.out.println(mf.getMedian());
        mf = new MedianFinder();
        System.out.println(mf.getMedian());
    }
}