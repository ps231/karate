package karate.chops.hash;

import java.util.*;

public class FindStudentWithTopAvgScoreAcrossThreeTopScores {
    public static void main(String[] args) {
        System.out.println(findStudentWithTopAvgScore(Arrays.asList("A,100", "B,100", "C,95", "D,98", "B,100", "A,85", "C,60", "D,83", "a,100", "C,100", "D,100", "A,100", "C,95", "d,99")));
        System.out.println(findStudentWithTopAvgScore(Arrays.asList("A,100", "B,100", "C,95", "D,98", "B,100", "A,85", "C,60", "D,83", "a,95", "C,100", "D,100", "A,100", "C,95", "d,99")));
    }

    private static String findStudentWithTopAvgScore(List<String> scores) {
        if (scores == null || scores.size() == 0)
            return null;

        Map<String, PriorityQueue<Integer>> studentTop3Map = new HashMap<>();
        for (String s : scores) {
            String[] record = s.split(",");
            if (record.length != 2)
                throw new IllegalArgumentException("invalid input");

            String studentName = record[0].toLowerCase();
            int currentScore = Integer.parseInt(record[1]);

            if (studentTop3Map.containsKey(studentName)) {
                if (studentTop3Map.get(studentName).size() != 3) {
                    PriorityQueue<Integer> topThreeScores = studentTop3Map.get(studentName);
                    topThreeScores.offer(currentScore);
                    studentTop3Map.put(studentName, topThreeScores);
                } else {
                    PriorityQueue<Integer> topThreeScores = studentTop3Map.get(studentName);
                    if (topThreeScores.peek() < currentScore) {
                        topThreeScores.poll();
                        topThreeScores.offer(currentScore);
                    }
                }
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(currentScore);
                studentTop3Map.put(studentName, pq);
            }
        }

        String studentWithMaxAvgScore = null;
        int maxAvgScore = Integer.MIN_VALUE;

        for (Map.Entry<String, PriorityQueue<Integer>> entry : studentTop3Map.entrySet()) {
            if (entry.getValue().size() < 3)
                continue;
            int avgScore = calculateAvgScore(entry.getValue());
            if (avgScore > maxAvgScore) {
                studentWithMaxAvgScore = entry.getKey();
                maxAvgScore = avgScore;
            }
        }
        return studentWithMaxAvgScore;
    }

    private static int calculateAvgScore(PriorityQueue<Integer> scores) {
        int sum = 0;
        while (!scores.isEmpty()) {
            sum += scores.poll();
        }
        return sum / 3;
    }
}
