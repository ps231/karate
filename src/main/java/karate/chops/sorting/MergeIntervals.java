package karate.chops.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> current = new ArrayList<>();
        current.add(new Interval(2, 5));
        current.add(new Interval(3, 4));
        current.add(new Interval(1, 3));
        current.add(new Interval(6, 8));
        mergeOverlappingIntervals(current).stream().forEach(i -> System.out.println("Start:" + i.start + ", End:" + i.end));

        current = new ArrayList<>();
        current.add(new Interval(2, 5));
        current.add(new Interval(3, 4));
        current.add(new Interval(6, 9));
        current.add(new Interval(13, 15));
        current.add(new Interval(10, 11));
        mergeOverlappingIntervals(current).stream().forEach(i -> System.out.println("Start:" + i.start + ", End:" + i.end));
    }

    private static List<Interval> mergeOverlappingIntervals(List<Interval> current) {
        if (current == null || current.size() == 0)
            throw new IllegalArgumentException("invalid input");

        Collections.sort(current, Comparator.comparingInt(Interval::getStart));

        List<Interval> merged = new ArrayList<>();
        for (Interval i : current) {
            if (merged.size() == 0) {
                merged.add(i);
            } else if (merged.get(merged.size() - 1).end >= i.start) {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, i.end);
            } else
                merged.add(i);
        }
        return merged;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int getStart() {
            return start;
        }
    }
}