package karate.chops.graphs;
import java.util.*;
//if an edge goes from u to v, then u depends on v. calculate sum of all such dependencies.
public class SumOfDependenciesInADirectedGraph {
	
	public static void main(String[] args) {
		System.out.println(calculateSumOfDependencies(GraphNodeHelper.getDirectedNonCyclicGraph()));
		System.out.println(calculateSumOfDependencies(GraphNodeHelper.getAnotherDirectedNonCyclicGraph()));
	}
	
	private static int calculateSumOfDependencies(List<GraphNode> nodes) {
		Map<Integer, Integer> nodeDependencies = new HashMap<Integer, Integer>();
		for(GraphNode n : nodes) {
			populateDependencies(n, nodeDependencies);
		}
		int sum = 0;
		for(Map.Entry<Integer, Integer>e : nodeDependencies.entrySet())
			sum+=e.getValue();
		return sum;
	}
	
	private static void populateDependencies(GraphNode n, Map<Integer, Integer> dependencies) {
		if(dependencies.containsKey(n.value))
			return;
		dependencies.put(n.value, n.adjacent.size());
		for(GraphNode adj : n.adjacent)
			populateDependencies(adj, dependencies);
	}
}
