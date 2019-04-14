package karate.chops.graphs;

import java.util.HashSet;
import java.util.Set;

public class DFSGraphTraversal {
	
	public static void main(String...strings) {
		DFSGraphTraversal d = new DFSGraphTraversal();
//		d.dfs(GraphNodeHelper.getGraph());
		d.dfs(GraphNodeHelper.anotherGraph());
	}

	private void dfs(GraphNode graph) {
		// TODO Auto-generated method stub
		Set<Integer> visited = new HashSet<Integer>();
		dfsHelper(graph, visited);
		
	}

	private void dfsHelper(GraphNode root, Set<Integer> visited) {
		// TODO Auto-generated method stub
		if(root == null || visited.contains(root.value))
			return;
		
		visited.add(root.value);
		System.out.println(root.value);
		
		for(int i =0; root.adjacent != null && i<root.adjacent.size();i++)
			dfsHelper(root.adjacent.get(i), visited);
		
	}

}
