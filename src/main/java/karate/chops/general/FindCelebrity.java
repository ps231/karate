package karate.chops.general;

import java.util.*;

public class FindCelebrity {
	private int findCelebrity(boolean[][] people) {

		Stack<Integer> celebrityStack = new Stack<Integer>();
		for (int i = 0; i < people.length; i++)
			celebrityStack.push(i);

		while (celebrityStack.size() >= 2) {
			int p1 = celebrityStack.pop();
			int p2 = celebrityStack.pop();

			if (knows(p1, p2, people))
				celebrityStack.push(p2);
			else
				celebrityStack.push(p1);
		}

		int potentialCelebrity = celebrityStack.pop();
		if (knowsNoOne(potentialCelebrity, people) && everyoneKnows(potentialCelebrity, people))
			return potentialCelebrity;
		return -1;
	}

	private boolean knows(int p1, int p2, boolean[][] people) {
		return people[p1][p2];
	}

	private boolean knowsNoOne(int p, boolean[][] people) {
		for (int i = 0; i < people[0].length; i++) {
			if (p != i && people[p][i])
				return false;
		}
		return true;
	}

	private boolean everyoneKnows(int p, boolean[][] people) {
		for (int i = 0; i < people.length; i++) {
			if (p != i && !people[i][p])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		FindCelebrity f = new FindCelebrity();
		System.out.println(f.findCelebrity(new boolean[][] { 
			{ false, false, true, true }, 
			{ true, false, true, false },
			{ false, false, false, false }, 
			{ false, false, true, false } }));
		System.out.println(f.findCelebrity(new boolean[][] { 
			{ false, false, true, true }, 
			{ true, false, true, false },
			{ false, false, false, true }, 
			{ false, false, true, false } }));
		System.out.println(f.findCelebrity(new boolean[][] { 
			{ false, false, false, false },
			{ true, false, true, false }, 
			{ true, false, false, false }, 
			{ true, false, true, false } }));
	}
}
