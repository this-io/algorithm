package scrap.lru_firstattempt.dlinkedlist;

public class DoubleLinkedList {
	DLinkedListNode sar;        //Head
	DLinkedListNode paer;       //Tail

	public void sarPeBithao(DLinkedListNode node) {
		if (sar == null) {
			sar = node;
			paer = node;
		} else {
			/*sar.previous = node;
			node.next = sar;
			paer = sar;
			sar = node;*/

			sar.previous = node;
			node.next = sar;
			sar = node;
		}
		System.out.println("sar =="+ sar.key);
		System.out.println("paer =="+ paer.key);
	}

	public int pichwadaHatao() {
		DLinkedListNode node = paer.previous;
		int paerKey = paer.key;
		paer = node;
		return paerKey;
	}
}
