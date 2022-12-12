package scrap.lru_firstattempt;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheOne extends LinkedHashMap<Integer, Integer>{
	private int capacity;

	public static void main(String[] args) {
		LRUCacheOne lru = new LRUCacheOne(2);
		String[] operation = {"LRUCacheOne", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
		Integer[][] input = {{2, null}, {1, 1}, {2, 2}, {1, null}, {3, 3}, {2, null}, {4, 4}, {1, null}, {3, null}, {4, null}};
		Integer[] output = new Integer[operation.length];

		for(int i=0; i<operation.length; i++) {
			if(operation[i].equals("LRUCacheOne")) {
				output[i] = null;
			} else if(operation[i].equals("put")) {
				lru.put(input[i][0], input[i][1]);
				output[i] = null;
			} else {
				System.out.println(lru.get(input[i][0]));
				output[i] = lru.get(input[i][0]);
			}
		}

		for(Integer i : output) {
			System.out.print(i + " ");
		}
	}

	public LRUCacheOne(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key,-1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
