package karate.chops.graphs;

import java.util.*;

public class GraphNodeHelper {
	public static GraphNode getGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);

		one.addEdge(two);
		one.addEdge(three);

		two.addEdge(four);
		two.addEdge(three);

		three.addEdge(four);
		three.addEdge(five);

		return one;
	}

	public static GraphNode anotherGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);
		GraphNode seven = new GraphNode(7);
		GraphNode eight = new GraphNode(8);
		GraphNode nine = new GraphNode(9);
		GraphNode ten = new GraphNode(10);

		one.addEdge(two);
		one.addEdge(three);

		two.addEdge(four);

		three.addEdge(eight);

		four.addEdge(five);
		four.addEdge(six);

		five.addEdge(seven);
		six.addEdge(seven);

		eight.addEdge(nine);
		eight.addEdge(ten);
		return one;
	}

	public static GraphNode getUndirectedCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);

		one.addEdge(two);
		one.addEdge(three);

		two.addEdge(four);
		two.addEdge(three);

		three.addEdge(five);

		return one;
	}

	public static GraphNode getUndirectedNonCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);

		one.addEdge(two);

		two.addEdge(four);
		two.addEdge(three);

		three.addEdge(five);

		return one;
	}

	public static GraphNode getAnotherUndirectedNonCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);

		one.addEdge(two);
		one.addEdge(four);

		two.addEdge(three);
		two.addEdge(six);

		four.addEdge(five);

		return one;
	}

	public static GraphNode getAnotherUndirectedCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);

		one.addEdge(two);
		one.addEdge(four);

		two.addEdge(three);
		two.addEdge(six);

		four.addEdge(five);

		five.addEdge(six);

		return one;
	}

	public static List<GraphNode> getDirectedCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);

		one.addDirectedEdge(two);
		one.addDirectedEdge(three);

		two.addDirectedEdge(three);

		three.addDirectedEdge(four);
		three.addDirectedEdge(one);

		four.addDirectedEdge(four);
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		return nodes;
	}

	public static List<GraphNode> getDirectedNonCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);

		one.addDirectedEdge(two);
		one.addDirectedEdge(three);

		two.addDirectedEdge(three);

		three.addDirectedEdge(four);
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		return nodes;
	}
	
	public static List<GraphNode> getAnotherDirectedNonCyclicGraph() {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);
		GraphNode seven = new GraphNode(7);

		one.addDirectedEdge(three);

		two.addDirectedEdge(three);
		two.addDirectedEdge(five);

		three.addDirectedEdge(four);
		four.addDirectedEdge(six);
		five.addDirectedEdge(six);
		six.addDirectedEdge(seven);
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		nodes.add(five);
		nodes.add(six);
		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		nodes.add(seven);
		return nodes;
	}
}