package main.implementation.easy;
/*
* Runtime: 26 ms, faster than 79.26% of Java online submissions for Logger Rate Limiter.
* Memory Usage: 46.7 MB, less than 86.60% of Java online submissions for Logger Rate Limiter.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

public class LoggerGoogle {
	Map<String, Integer> keeper;
	List<Boolean> isPrintable;
	/** Initialize your data structure here. */
	public LoggerGoogle() {
		keeper = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	 If this method returns false, the message will not be printed.
	 The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		boolean result;
		if(keeper.containsKey(message)) {
			if(timestamp >= (keeper.get(message) + 10)) {
				keeper.put(message, timestamp);
				result = true;
			} else {
				result = false;
			}
		} else {
			keeper.put(message, timestamp);
			result = true;
		}
		return result;
	}

	/*
	* [], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
	* */
	public static void main(String[] args) {
		LoggerGoogle google = new LoggerGoogle();
		Map<Integer, String> input = new HashMap<Integer, String>(){{
			put(0, "");
			put(1, "foo");
			put(2, "bar");
			put(3, "foo");
			put(8, "bar");
			put(10, "foo");
			put(11, "foo");
		}};

		google.isPrintable = new ArrayList<>();
		for(int val : input.keySet()) {
			Boolean result;
			if(input.get(val).isEmpty()) {
				result = null;
			} else {
				result = google.shouldPrintMessage(val, input.get(val));
				google.isPrintable.add(result);
			}
			google.isPrintable.add(result);
			System.out.print(result + " ");
		}
	}
}
