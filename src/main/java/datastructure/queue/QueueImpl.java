package datastructure.queue;

public class QueueImpl {
	public static void main(String[] args) {
		QueueImpl queue = new QueueImpl();
		queue.start();
	}

	private void start() {
		QueueLinkedList qll = new QueueLinkedList();
		qll.insert(10);
		qll.insert(11);
		qll.insert(12);
		qll.insert(13);
		qll.insert(14);
		qll.insert(15);
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();
		System.out.println("============");
		qll.delete();
		qll.display();

	}
}
