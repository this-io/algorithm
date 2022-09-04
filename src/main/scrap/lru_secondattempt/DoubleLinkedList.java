package main.scrap.lru_secondattempt;

public class DoubleLinkedList {
	DLinkedListNode mostRecentlyUsed;
	DLinkedListNode leastRecentlyUsed;

	public DLinkedListNode addNode(int key, int value) {
		DLinkedListNode node = new DLinkedListNode(key, value);
		changeHead(node);
		return node;
	}

	public void changeHead(DLinkedListNode node) {
		if (mostRecentlyUsed == null) {
			mostRecentlyUsed = node;
			leastRecentlyUsed = node;
		} else {
			if (node.next != null && node.previous != null) {
				//middle
				node.previous.next = node.next;
				node.next.previous = node.previous;
				node.next = mostRecentlyUsed;
				mostRecentlyUsed.previous = node;
				mostRecentlyUsed = node;
			} else if (leastRecentlyUsed.key == node.key) {
				node.next = mostRecentlyUsed;
				mostRecentlyUsed.previous = node;
				mostRecentlyUsed = node;
				leastRecentlyUsed = leastRecentlyUsed.previous;
			} else {
				if(mostRecentlyUsed != node) {
					node.next = mostRecentlyUsed;
					mostRecentlyUsed.previous = node;
					mostRecentlyUsed = node;
				}
			}
		}
	}

	public int removeTail() {
		DLinkedListNode node = mostRecentlyUsed;
		int removedKey = -1;
		System.out.println(leastRecentlyUsed.key);
		if (leastRecentlyUsed != null) {
			removedKey = leastRecentlyUsed.key;
			leastRecentlyUsed = leastRecentlyUsed.previous;
		}

		return removedKey;
	}
}
