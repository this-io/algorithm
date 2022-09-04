package main.scrap.lru_firstattempt.dlinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, DLinkedListNode> theLRU;
	DoubleLinkedList dll;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		dll = new DoubleLinkedList();
		theLRU = new HashMap<>();
	}

	public int get(int key) {
		int output = 0;
		if (theLRU.containsKey(key)) {
			DLinkedListNode node = theLRU.get(key);
			if(node.next.previous != null && node.previous != null) {
				node.next.previous = node.previous;
			}
			if(node.previous != null && node.previous.next != null && node.next != null) {
				node.previous.next = node.next;
			}
			dll.sarPeBithao(node);
			output = node.value;
		} else {
			output = -1;
		}
		return output;
	}

	public void put(int key, int value) {
		int currentPaerKey = -1;
		if (theLRU.size() >= capacity) {
			//System.out.println(dll.pichwadaHatao());
			if(!theLRU.containsKey(key)) {
				theLRU.remove(dll.pichwadaHatao());
			}
		}

		DLinkedListNode node = new DLinkedListNode();
		node.key = key;
		node.value = value;
		dll.sarPeBithao(node);

		theLRU.put(key, node);
	}
}
