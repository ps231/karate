package karate.chops.heaps;

import java.util.*;

public class StackAsAHeap {
	private PriorityQueue<Temp> maxHeap = new PriorityQueue<Temp>();
	private int timestamp = 0;

	public static void main(String[] arsg) {
		StackAsAHeap myStack = new StackAsAHeap();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);

		System.out.println(myStack.pop());
		System.out.println(myStack.pop());

		myStack.push(5);

		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}

	public void push(int value) {
		maxHeap.offer(new Temp(value, timestamp++));
	}

	public int pop() {
		if (maxHeap.isEmpty())
			throw new RuntimeException("Stack is empty");
		return maxHeap.poll().val;
	}
}

class Temp implements Comparable<Temp> {
	int val;
	int priority;

	Temp(int v, int p) {
		val = v;
		priority = p;
	}

	public int compareTo(Temp t) {
		return Integer.compare(t.priority, this.priority);
	}
}
