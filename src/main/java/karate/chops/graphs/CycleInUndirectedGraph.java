package karate.chops.graphs;

import java.util.*;

public class CycleInUndirectedGraph {

	public static void main(String[] args) {
		detectCycle(GraphNodeHelper.getUndirectedCyclicGraph());
		detectCycle(GraphNodeHelper.getAnotherUndirectedCyclicGraph());
		detectCycle(GraphNodeHelper.getAnotherUndirectedNonCyclicGraph());
		detectCycle(GraphNodeHelper.getUndirectedNonCyclicGraph());
	}

	private static void detectCycle(GraphNode root) {
		Set<Integer> visited = new HashSet<Integer>();
		if (hasCycle(null, root, visited))
			System.out.println("Cycle detected");
		else
			System.out.println("Cycle not detected");
	}

	private static boolean hasCycle(GraphNode parent, GraphNode cur, Set<Integer> visited) {
		if (visited.contains(cur.value))
			return true;
		visited.add(cur.value);
		for (GraphNode adj : cur.adjacent) {
			if (parent != null && adj.value == parent.value)
				continue;
			if (hasCycle(cur, adj, visited))
				return true;
		}
		return false;
	}
}
