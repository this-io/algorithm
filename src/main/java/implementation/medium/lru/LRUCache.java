package implementation.medium.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, Node> theCache;
	int capacity;
	DoubleLinkedList dll;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		theCache = new HashMap<>();
		dll = new DoubleLinkedList();
	}

	public int get(int key) {
		if(theCache.containsKey(key)) {
			Node tempNode = theCache.get(key);
			dll.toHead(tempNode);
			return tempNode.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(theCache.containsKey(key)) {
			Node tempNode = theCache.get(key);
			//tempNode.key = key;
			tempNode.value = value;
			theCache.put(key, tempNode);
			dll.toHead(tempNode);
		} else {
			if(theCache.size() >= capacity) {
				Node removedNode = dll.removeTail();
				if(removedNode != null) {
					theCache.remove(removedNode.key);
				}
				Node tempNode = dll.addNode(key, value);

				theCache.put(key, tempNode);
				dll.toHead(tempNode);
			} else {
				Node tempNode = dll.addNode(key, value);
				theCache.put(key, tempNode);
				dll.toHead(tempNode);
			}
		}
	}
}
