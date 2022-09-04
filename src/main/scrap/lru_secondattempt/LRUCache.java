package main.scrap.lru_secondattempt;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, DLinkedListNode> theCache;
	int capacity;
	DoubleLinkedList dll;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		theCache = new HashMap<>();
		dll = new DoubleLinkedList();
	}

	public int get(int key) {
		int output = 0;
		if (theCache.containsKey(key)) {
			DLinkedListNode node = theCache.get(key);
			dll.changeHead(node);
			output = node.value;
		} else {
			output = -1;
		}
		System.out.print("\n DLL get: ");
		DLinkedListNode k = dll.mostRecentlyUsed;
		while(k.next != null) {
			System.out.print(k.key+ "  ");
			k = k.next;
		}
		System.out.print("\n ");
		return output;
	}

	public void put(int key, int value) {
		DLinkedListNode node = null;
		if (theCache.size() >= capacity) {
			int currentRemovedKey = dll.removeTail();
			theCache.remove(currentRemovedKey);
		}

		if (theCache.containsKey(key)) {
			node = theCache.get(key);
			node.value = value;
			dll.changeHead(node);
		} else {
			node = dll.addNode(key, value);
		}
		theCache.put(key, node);

		System.out.println("\n DLL put: ");
		DLinkedListNode k = dll.mostRecentlyUsed;
		if(k.next == null ) {
			System.out.print(k.key+ " ");
		}
		while(k.next != null) {
			System.out.print(k.key+ "  ");
			k = k.next;
		}
		System.out.println("\n");
	}
}
