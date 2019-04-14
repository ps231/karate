package karate.chops.graphs;

import java.util.*;

public class BFSGraphTraversal {

	public static void main(String...strings) {
		BFSGraphTraversal b= new BFSGraphTraversal();
//		b.bfs(GraphNodeHelper.getGraph());
		b.bfs(GraphNodeHelper.anotherGraph());
	}

	private void bfs(GraphNode root) {
		// TODO Auto-generated method stub
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		Set<Integer> visited = new HashSet<Integer>();
		
		if(root!=null)
			q.add(root);
		
		while(!q.isEmpty()) {
			root = q.poll();
			
			if(visited.contains(root.value))
				continue;
			
			visited.add(root.value);
			System.out.println(root.value);
			
			q.addAll(root.adjacent);
			
		}
	}
}
