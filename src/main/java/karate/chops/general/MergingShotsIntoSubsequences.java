package karate.chops.general;
import java.util.*;
public class MergingShotsIntoSubsequences {
	
	public static void main(String...strings) {
		MergingShotsIntoSubsequences s = new MergingShotsIntoSubsequences();
		List<Character> shots = new ArrayList<>();
		shots.add('a');
		shots.add('b');
		shots.add('a');
		shots.add('b');
		shots.add('c');
		shots.add('b');
		shots.add('a');
		shots.add('c');
		shots.add('a');
		shots.add('d');
		shots.add('e');
		shots.add('f');
		shots.add('e');
		shots.add('g');
		shots.add('d');
		shots.add('e');
		shots.add('h');
		shots.add('i');
		shots.add('j');
		shots.add('h');
		shots.add('k');
		shots.add('l');
		shots.add('i');
		shots.add('j');
		List<Integer> subsequences = s.partitionShots(shots);
		subsequences.stream().forEach(System.out::println);
	}
	
	public List<Integer> partitionShots(List<Character> shots){

		Map<Character, Interval> intervalsMap = new HashMap<Character, Interval>();

		for(int i =0; i<shots.size(); i++){
			if(intervalsMap.containsKey(shots.get(i))) {
				intervalsMap.get(shots.get(i)).end = i;
			} else {
				intervalsMap.put(shots.get(i), new Interval(i, i));
			}
		}
		List<Interval> sortedIntervals = new ArrayList<>(intervalsMap.values());
		Collections.sort(sortedIntervals, new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2){
					return Integer.compare(i1.start, i2.start);
				}
			});

		List<Interval> mergedIntervals = new ArrayList<Interval>();
		
		for(Interval i : sortedIntervals){
			if(mergedIntervals.isEmpty()){
				mergedIntervals.add(i);
			} else {
				if(mergedIntervals.get(mergedIntervals.size()-1).end >= i.end)
					continue;
				else if(mergedIntervals.get(mergedIntervals.size()-1).end < i.start){
					mergedIntervals.add(i);
				} else
					mergedIntervals.get(mergedIntervals.size()-1).end = i.end;
			}
		}

		List<Integer> subsequenceLength = new ArrayList<Integer>();

		for(Interval merged : mergedIntervals)
			subsequenceLength.add(merged.end - merged.start + 1);

		return subsequenceLength;
		
	}

}

class Interval{
	int start;
	int end;
	Interval (int s, int e){
		start = s;
		end = e;
	}
}


