package karate.chops.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPathFromSourceToDestination {
    public static void main(String[] args) {
        List<Pair> tickets = new ArrayList<>();
        tickets.add(new Pair("slc", "sea"));
        tickets.add(new Pair("sea", "slc"));
        tickets.add(new Pair("slc", "sea"));
        tickets.add(new Pair("den", "lax"));
        tickets.add(new Pair("lax", "lv"));
        tickets.add(new Pair("slc", "den"));
        tickets.add(new Pair("den", "sea"));
        tickets.add(new Pair("lv", "sea"));

        System.out.println(hasPath("slc", "sea", 1, tickets));
        System.out.println(hasPath("slc", "sea", 2, tickets));
        System.out.println(hasPath("slc", "sea", 3, tickets));
        System.out.println(hasPath("slc", "sea", 4, tickets));
        System.out.println(hasPath("slc", "sea", 5, tickets));
        System.out.println(hasPath("lv", "slc", 2, tickets));
        System.out.println(hasPath("lv", "lax", 1, tickets));
        System.out.println(hasPath("lax", "sea", 3, tickets));
    }

    private static boolean hasPath(String src, String dst, int hops, List<Pair> tickets) {
        validateInputArgs(src, dst, hops, tickets);
        Map<String, Map<String, Integer>> routesMap = buildRoutesMap(tickets);
        return pathHelper(src, dst, hops, routesMap, 0);
    }

    private static void validateInputArgs(String src, String dst, int hops, List<Pair> tickets) {
        if (src == null || src.length() == 0 || dst == null || dst.length() == 0 || hops <= 0 || tickets == null || tickets.size() == 0)
            throw new IllegalArgumentException("invalid input");
    }

    private static Map<String, Map<String, Integer>> buildRoutesMap(List<Pair> tickets) {
        Map<String, Map<String, Integer>> routesMap = new HashMap<>();

        for (Pair ticket : tickets) {
            if (!routesMap.containsKey(ticket.getLeft())) {
                Map<String, Integer> dstMap = new HashMap<>();
                routesMap.put(ticket.getLeft(), dstMap);
                routesMap.get(ticket.getLeft()).put(ticket.getRight(), 1);
            } else {
                if (!routesMap.get(ticket.getLeft()).containsKey(ticket.getRight())) {
                    routesMap.get(ticket.getLeft()).put(ticket.getRight(), 1);
                } else {
                    routesMap.get(ticket.getLeft()).put(ticket.getRight(), routesMap.get(ticket.getLeft()).get(ticket.getRight()) + 1);
                }
            }
        }
        return routesMap;
    }

    private static boolean pathHelper(String src, String dst, int hops, Map<String, Map<String, Integer>> routesMap, int currentHop) {
        if (currentHop > hops)
            return false;
        if (currentHop == hops && src.equals(dst))
            return true;
        for (Map.Entry<String, Integer> entry : routesMap.get(src).entrySet()) {
            if (entry.getValue() != 0) {
                entry.setValue(entry.getValue() - 1);
                if (pathHelper(entry.getKey(), dst, hops, routesMap, currentHop + 1))
                    return true;
                entry.setValue(entry.getValue() + 1);
            }
        }
        return false;
    }

    private static class Pair {
        String left;
        String right;

        Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }
    }
}