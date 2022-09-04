package main.implementation.medium;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
	private Queue<Integer> hits;
	public static void main(String[] args) {
		HitCounter hc = new HitCounter();
		String[] op = {"HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"};
		int[][] input = {{}, {1}, {2}, {3}, {4}, {300}, {300}, {301}};
		Integer[] output = new Integer[op.length];

		for(int i=0; i<op.length;i++) {
			if(!op[i].equals("HitCounter")) {
				if(op[i].equals("hit")) {
					hc.hit(input[i][0]);
					output[i] = null;
				} else {
					output[i] = hc.getHits(input[i][0]);
				}
			} else {
				output[i] = null;
			}
		}

		for(Integer i : output) {
			System.out.print(i+" ");
		}
	}

	/** Initialize your data structure here. */
	public HitCounter() {
		hits = new LinkedList<>();
	}

	/** Record a hit.
	 @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		this.hits.add(timestamp);
	}

	/** Return the number of hits in the past 5 minutes.
	 @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		while(!this.hits.isEmpty()) {
			int diff = timestamp - this.hits.peek();
			if(diff >= 300) {
				this.hits.remove();
			} else {
				break;
			}
		}
		return this.hits.size();
	}
}
