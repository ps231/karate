package karate.chops.heaps;
import java.util.*;
public class QueueAsAHeap {

	private PriorityQueue<QueueEntry> minHeap = new PriorityQueue<QueueEntry>(new Comparator<QueueEntry>() {
		public int compare(QueueEntry t1, QueueEntry t2) {
			return Integer.compare(t1.priority, t2.priority);
		}
	});
	private int timestamp = 0;

	public static void main(String[] arsg) {
		QueueAsAHeap myQ = new QueueAsAHeap();
		myQ.offer(1);
		myQ.offer(2);
		myQ.offer(3);
		myQ.offer(4);

		System.out.println(myQ.poll());
		System.out.println(myQ.poll());

		myQ.offer(5);

		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
	}

	public void offer(int value) {
		minHeap.offer(new QueueEntry(value, timestamp++));
	}

	public int poll() {
		if (minHeap.isEmpty())
			throw new RuntimeException("Queue is empty");
		return minHeap.poll().val;
	}
}

class QueueEntry implements Comparable<QueueEntry> {
	int val;
	int priority;

	QueueEntry(int v, int p) {
		val = v;
		priority = p;
	}

	public int compareTo(QueueEntry t) {
		return Integer.compare(t.priority, this.priority);
	}
}
