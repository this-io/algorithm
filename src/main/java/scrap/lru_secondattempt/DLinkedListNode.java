package scrap.lru_secondattempt;

public class DLinkedListNode {
	public int key;
	public int value;
	public DLinkedListNode previous;
	public DLinkedListNode next;

	public DLinkedListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
