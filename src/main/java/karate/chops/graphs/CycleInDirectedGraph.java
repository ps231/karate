package karate.chops.graphs;

import java.util.*;

public class CycleInDirectedGraph {

	public static void main(String[] arsg) {
		System.out.println(isCycle(GraphNodeHelper.getDirectedCyclicGraph()));
		System.out.println(isCycle(GraphNodeHelper.getDirectedNonCyclicGraph()));
	}

	private static boolean isCycle(List<GraphNode> A) {
		Set<GraphNode> white = new HashSet<GraphNode>(A);
		Set<GraphNode> grey = new HashSet<GraphNode>();
		Set<GraphNode> black = new HashSet<GraphNode>();

		while (white.iterator().hasNext()) {
			if (cycleDetected(white, grey, black, white.iterator().next()))
				return true;
		}
		return false;
	}

	private static boolean cycleDetected(Set<GraphNode> white, Set<GraphNode> grey, Set<GraphNode> black,
			GraphNode root) {

		if (white.contains(root)) {
			white.remove(root);
		}

		if (black.contains(root))
			return false;

		if (grey.contains(root))
			return true;

		grey.add(root);
		for (GraphNode adj : root.adjacent) {
			if (cycleDetected(white, grey, black, adj))
				return true;
		}
		grey.remove(root);
		black.add(root);
		return false;
	}
}
