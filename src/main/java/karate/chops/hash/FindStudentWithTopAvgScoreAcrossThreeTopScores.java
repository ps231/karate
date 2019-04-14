package karate.chops.hash;

import java.util.*;

public class FindStudentWithTopAvgScoreAcrossThreeTopScores {
	public static void main(String[] args) {
		String[] studentScores = new String[] { "A,100", "B,100", "C,95", "D,98", "B,100", "A,85", "C,60", "D,83",
				"A,100", "C,100", "D,100", "A,95", "C,95", "D,99" };
		System.out.println(findStudentWithTopAvgScore(Arrays.asList(studentScores)));
	}

	private static String findStudentWithTopAvgScore(List<String> scores) {

		if (scores == null || scores.size() == 0)
			return null;

		Map<String, PriorityQueue<Integer>> studentScoresMap = new HashMap<String, PriorityQueue<Integer>>();

		for (String record : scores) {
			String[] splits = record.split(",");
			if (!studentScoresMap.containsKey(splits[0])) {
				studentScoresMap.put(splits[0], new PriorityQueue<Integer>(new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return Integer.compare(i1, i2);
					}
				}));
			}
			if (studentScoresMap.get(splits[0]).size() != 3) {
				studentScoresMap.get(splits[0]).offer(Integer.parseInt(splits[1]));
			} else if (studentScoresMap.get(splits[0]).peek() < Integer.parseInt(splits[1])) {
				studentScoresMap.get(splits[0]).poll();
				studentScoresMap.get(splits[0]).offer(Integer.parseInt(splits[1]));
			} 
		}

		double maxAvgScore = Double.MIN_VALUE;
		String studentName = null;

		for (Map.Entry<String, PriorityQueue<Integer>> entry : studentScoresMap.entrySet()) {
			if (entry.getValue().size() == 3) {
				int total = 0;
				while (entry.getValue().size() != 0) {
					total += entry.getValue().poll();
				}
				int avgScore = total / 3;
				if (avgScore > maxAvgScore) {
					maxAvgScore = avgScore;
					studentName = entry.getKey();
				}
			}
		}
		return studentName;
	}
}
