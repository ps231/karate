package karate.chops.graphs;

import java.util.*;

public class MovieRecommendation {
	public static void main(String... strings) {
		new MovieRecommendation()
			.getKTopRatedMovies(getMovieGraph(), 10)
			.stream()
			.forEach(System.out::println);
	}

	public List<String> getKTopRatedMovies(MovieNode root, int k) {
		List<String> topKRecommendations = new ArrayList<String>();
		PriorityQueue<MovieNode> minHeap = new PriorityQueue<MovieNode>(new Comparator<MovieNode>() {
			public int compare(MovieNode i1, MovieNode i2) {
				return Integer.compare(i1.rating, i2.rating);
			}
		});
		Queue<MovieNode> q = new LinkedList<MovieNode>();
		Set<String> uniqueMovies = new HashSet<String>();

		if (root == null)
			return topKRecommendations;
		q.offer(root);

		while (!q.isEmpty()) {
			MovieNode n = q.poll();
			if (uniqueMovies.contains(n.value))
				continue;

			uniqueMovies.add(n.value);
			q.addAll(n.adjacent);

			if (minHeap.size() < k) {
				minHeap.add(n);
			} else {
				if (minHeap.peek().rating < n.rating) {
					minHeap.poll();
					minHeap.add(n);
				}
			}

		}

		while (!minHeap.isEmpty())
			topKRecommendations.add(minHeap.poll().value);

		return topKRecommendations;

	}

	public static MovieNode getMovieGraph() {
		MovieNode m1 = new MovieNode("A", 2);
		MovieNode m2 = new MovieNode("B", 6);
		MovieNode m3 = new MovieNode("C", 4);
		MovieNode m4 = new MovieNode("D", 8);

		m1.addEdge(m2);
		m1.addEdge(m3);

		m2.addEdge(m4);
		m3.addEdge(m4);

		return m1;
	}
}

class MovieNode {
	public int rating;
	String value;
	List<MovieNode> adjacent;

	public MovieNode(String value, int rating) {
		this.value = value;
		this.rating = rating;
		this.adjacent = new ArrayList<>();
	}

	public void addEdge(MovieNode node) {
		adjacent.add(node);
		node.adjacent.add(this);
	}
}