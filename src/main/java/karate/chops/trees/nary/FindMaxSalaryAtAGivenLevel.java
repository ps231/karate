package karate.chops.trees.nary;

import java.util.*;

public class FindMaxSalaryAtAGivenLevel {

	public static void main(String[] args) {
		NaryNode org = NaryTreeHelper.createOrgStructure();
		int maxSalary = getMaxSalaryAtLevel(org, "Z");
		System.out.println(maxSalary);
	}

	private static int getMaxSalaryAtLevel(NaryNode n, String name) {
		Queue<NaryNode> q1 = new LinkedList<NaryNode>();
		Queue<NaryNode> q2 = new LinkedList<NaryNode>();
		boolean levelFound = false;
		int maxSalaryAtLevel = Integer.MIN_VALUE;

		if (n == null)
			return maxSalaryAtLevel;

		if (name.equals(n.val))
			return n.salary;

		q1.offer(n);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (levelFound) {
				while (!q1.isEmpty()) {
					NaryNode t = q1.poll();
					maxSalaryAtLevel = Math.max(t.salary, maxSalaryAtLevel);
				}
				return maxSalaryAtLevel;
			} else {
				while (!q1.isEmpty()) {
					NaryNode root = q1.poll();
					if (root.children != null) {
						for (NaryNode child : root.children) {
							if (child.val.equals(name))
								levelFound = true;
							q2.offer(child);
						}
					}
				}
			}

			if (levelFound) {
				while (!q2.isEmpty()) {
					NaryNode t = q2.poll();
					maxSalaryAtLevel = Math.max(t.salary, maxSalaryAtLevel);
				}
				return maxSalaryAtLevel;
			} else {
				while (!q2.isEmpty()) {
					NaryNode root = q2.poll();
					if (root.children != null) {
						for (NaryNode child : root.children) {
							if (child.val.equals(name))
								levelFound = true;
							q1.offer(child);
						}
					}
				}
			}
		}
		return maxSalaryAtLevel;
	}

}
