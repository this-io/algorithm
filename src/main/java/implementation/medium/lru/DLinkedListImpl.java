package implementation.medium.lru;

public class DLinkedListImpl {
	public static void main(String[] args) {
		//int[][] input = {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}};
		/*DoubleLinkedList dll = new DoubleLinkedList();
		Map<Integer, Node> theMap = new HashMap<>();
		for(int i=0; i<=10; i++) {
			Node node = dll.addNode(i,i);
			theMap.put(i, node);
		}
		dll.display();
		System.out.println("\n"+dll.peak());

		dll.toHead(theMap.get(10));
		dll.display();
		System.out.println("\n");
		dll.toHead(theMap.get(8));
		dll.display();
		*/
		DLinkedListImpl d = new DLinkedListImpl();
		String[] operation = {"LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"};
		Integer[][] input = {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}};
		System.out.println("Expected: null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5");
		System.out.print("Output:   ");
		d.process(operation, input);
		System.out.println("\n");

		String[] operation1 = {"LRUCache","put","get","put","get","get"};
		Integer[][] input1 = {{1},{2,1},{2},{3,2},{2},{3}};
		System.out.println("Expected: null,null,1,null,-1,2");
		System.out.print("Output:   ");d.process(operation1, input1);
		System.out.println("\n");

		String[] operation2 ={"LRUCache","get","put","get","put","put","get","get"};
		Integer[][] input2 ={{2},{2},{2,6},{1},{1,5},{1,2},{1},{2}};
		System.out.println("Expected: null,-1,null,-1,null,null,2,6");
		System.out.print("Output:   ");d.process(operation2, input2);
		System.out.println("\n");

		String[] operation3 ={"LRUCache","put","put","put","put","get","get"};
		Integer[][] input3 ={{2},{2,1},{1,1},{2,3},{4,1},{1},{2}};
		System.out.println("Expected: null,null,null,null,null,-1,3");
		System.out.print("Output:   ");
		d.process(operation3, input3);
	}

	private void process(String[] operation, Integer[][] input) {
		Integer[] output = new Integer[operation.length];
		LRUCache lru = null;
		for (int i = 0; i < operation.length; i++) {
			if (operation[i].equals("LRUCache")) {
				lru = new LRUCache(input[i][0]);
				output[i] = null;
			} else if (operation[i].equals("put")) {
				lru.put(input[i][0], input[i][1]);
				output[i] = null;
			} else {
				output[i] = lru.get(input[i][0]);
			}
		}
		for (Integer i : output) {
			System.out.print(i + ",");
		}
	}
}
