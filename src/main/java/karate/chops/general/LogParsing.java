package karate.chops.general;

import java.util.*;

public class LogParsing {
	
	public static void main(String...args) {
		LogParsing p = new LogParsing();
		List<String> logLines = new ArrayList<String>();
		logLines.add("a1 9 2 3 1");
		logLines.add("g1 act car");
		logLines.add("z04 4 7");
		logLines.add("a21 act car");
		logLines.add("ab1 off key dog");
		logLines.add("a8 act zoo");
		List<String> sortedLogs = p.sortLogFile(6, logLines);
		
		sortedLogs.stream().forEach(System.out::println);
	}

	public List<String> sortLogFile(int logFileSize, List<String> logLines) {
		List<String> results = new ArrayList<String>();

		List<String> numericDataLogs = new ArrayList<String>();

		Set<LogRecord> sortedSet = new TreeSet<LogRecord>();

		for(String log : logLines) {

			String[] tokens = log.split(" ");
			
			try {
				int num = Integer.parseInt(tokens[1]);
				numericDataLogs.add(log);
			} catch(NumberFormatException e) {
				StringBuilder data = new StringBuilder();
				for(int i = 1; i < tokens.length; i++)
					data.append(tokens[i] + " ");
				LogRecord rec = new LogRecord(tokens[0], data.toString());
				sortedSet.add(rec);
			}

		}

		for(LogRecord rec : sortedSet) {
			results.add(rec.toString());
		}

		results.addAll(numericDataLogs);

		return results;

		}

	

}

class LogRecord implements Comparable<LogRecord>{
	String identifier;
	String data;

	public LogRecord(String id, String d) {
		identifier = id;
		data = d;
	}

	public int compareTo(LogRecord another) {

		if (!this.data.equals(another.data))
			return this.data.compareTo(another.data);
		return this.identifier.compareTo(another.identifier);
	}

	public String toString() {
		return this.identifier + " " + this.data;
	}
}
