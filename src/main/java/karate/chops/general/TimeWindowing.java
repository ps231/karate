package karate.chops.general;

import java.util.HashMap;
import java.util.Map;

public class TimeWindowing {

	private int hitsCounter = 0;
	private Map<Integer, Integer> hitsMap = new HashMap<Integer, Integer>();

	public static void main(String... args) {
		TimeWindowing t = new TimeWindowing();
		for (int i = 0; i < 5; i++) {
			t.addHits(i, i);
		}
		System.out.println(t.getHits());
		for (int i = 5; i < 10; i++) {
			t.addHits(i, i);
			System.out.println(t.getHits());
		}
	}

	private void addHits(int timestamp, int hits) {
		if (timestamp >= 5)
			hitsCounter -= hitsMap.get(timestamp - 5);

		if (hitsMap.containsKey(timestamp)) {
			hitsMap.put(timestamp, hitsMap.get(timestamp) + hits);
		} else {
			hitsMap.put(timestamp, hits);
		}
		hitsCounter += hits;
	}

	private int getHits() {
		return hitsCounter;
	}
}
