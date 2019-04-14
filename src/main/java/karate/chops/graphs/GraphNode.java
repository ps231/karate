package karate.chops.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    List<GraphNode> adjacent;

    public GraphNode(int value) {
        this.value = value;
        this.adjacent = new ArrayList<>();
    }

    public void addEdge(GraphNode node) {
        adjacent.add(node);
        node.adjacent.add(this);
    }
    
    public void addDirectedEdge(GraphNode node) {
        adjacent.add(node);
    }

	@Override
	public String toString() {
		return "GraphNode [value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (value != other.value)
			return false;
		return true;
	}

	
}
