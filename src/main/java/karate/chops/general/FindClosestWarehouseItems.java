package karate.chops.general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestWarehouseItems {

	public static void main(String... strings) {
		List<Coordinate> items = new ArrayList<Coordinate>();
		items.add(new Coordinate(1, 2));
		items.add(new Coordinate(3, 4));
		items.add(new Coordinate(2, 3));
		items.add(new Coordinate(5, 7));
		items.add(new Coordinate(1, -1));

		List<Coordinate> closest = returnClosest(items, 5, 3);

		closest.stream().forEach(System.out::println);
	}

	private static List<Coordinate> returnClosest(List<Coordinate> locations, int totalCrates, int truckCapacity) {

		List<Coordinate> closest = new ArrayList<Coordinate>();
		calculateDistanceFromTruck(locations);

		PriorityQueue<Coordinate> maxHeap = new PriorityQueue<Coordinate>(new Comparator<Coordinate>() {
			public int compare(Coordinate c1, Coordinate c2) {
				return Double.compare(c2.distance, c1.distance);
			}
		});

		for (Coordinate c : locations) {

			if (maxHeap.size() < truckCapacity) {
				maxHeap.add(c);
			} else {
				if (c.distance < maxHeap.peek().distance) {
					maxHeap.poll();
					maxHeap.add(c);
				}
			}
		}

		while (!maxHeap.isEmpty())
			closest.add(maxHeap.poll());

		return closest;
	}

	private static void calculateDistanceFromTruck(List<Coordinate> locations) {

		for (Coordinate c : locations) {
			c.distance = Math.sqrt(Math.pow(c.x, 2) + Math.pow(c.y, 2));
		}
	}
}

class Coordinate {
	int x;
	int y;
	double distance;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x=" + x + ", y=" + y;
	}

}
