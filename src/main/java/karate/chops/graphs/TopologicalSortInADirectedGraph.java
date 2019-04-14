package karate.chops.graphs;

import java.util.*;

public class TopologicalSortInADirectedGraph {
	public static void main(String[] args) {
		printTopologicalSort(GraphNodeHelper.getDirectedNonCyclicGraph());
		printTopologicalSort(GraphNodeHelper.getAnotherDirectedNonCyclicGraph());
	}

	private static void printTopologicalSort(List<GraphNode> A) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for (GraphNode n : A) {
			if (visited.contains(n))
				continue;
			helper(n, visited, stack);
		}
		print(stack);
	}

	private static void print(Stack<GraphNode> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().value + " ");
		}
		System.out.println("");
	}

	private static void helper(GraphNode root, Set<GraphNode> visited, Stack<GraphNode> stack) {
//		if (visited.contains(root))
//			return;

		visited.add(root);
		for (GraphNode adj : root.adjacent) {
			if (!visited.contains(adj))
				helper(adj, visited, stack);
		}
		stack.push(root);
	}
}
