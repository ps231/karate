package karate.chops.general;

import java.util.*;

public class LRUCache {
	private Map<Integer, String> cache = new HashMap<Integer, String>();
	private Queue<Integer> q;
	private int cacheSize;

	public LRUCache(int size) {
		cacheSize = size;
		q = new LinkedList<Integer>();
	}

	public void put(int key, String value) {
		if (q.size() >= cacheSize) {
			int evictedKey = q.poll();
			cache.remove(evictedKey);
		}
		cache.put(key, value);
		q.offer(key);

	}

	public String get(int key) {
		if (cache.containsKey(key)) {
			q.remove(key);
			q.offer(key);
		}
		return cache.get(key);
	}

	public static void main(String... args) {
		LRUCache cache = new LRUCache(3);
		cache.put(1, "one");
		cache.put(2, "two");
		cache.put(3, "three");
		cache.put(4, "four");
		cache.printCache();

		System.out.println(cache.get(3));
		cache.put(5, "five");
		cache.put(6, "six");

		cache.printCache();
	}

	private void printCache() {
		for (Map.Entry<Integer, String> entry : cache.entrySet())
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	}
}
