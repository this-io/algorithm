package scrap.lru_secondattempt;

public class UseLru {
	public static void main(String[] args) {
		LRUCache lru = null;
		//String[] operation = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
		//Integer[][] input = {{2, null}, {1, 1}, {2, 2}, {1, null}, {3, 3}, {2, null}, {4, 4}, {1, null}, {3, null}, {4, null}};

		//String[] operation = {"LRUCache","put","get","put","get","get"};
		//Integer[][] input = {{1},{2,1},{2},{3,2},{2},{3}};

		//String[] operation = {"LRUCache","get","put","get","put","put","get","get"};
		//Integer[][] input = {{2},{2},{2,6},{1},{1,5},{1,2},{1},{2}};

		String[] operation = {"LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"};
		Integer[][] input = {{3},{1,1},{2,2},{3,3},{4,4},{4},{3},{2},{1},{5,5},{1},{2},{3},{4},{5}};

		Integer[] output = new Integer[operation.length];

		for (int i = 0; i < operation.length; i++) {
			System.out.println("op: "+ operation[i] + "\t\t" + " key :" + input[i][0]);
			if (operation[i].equals("LRUCache")) {
				lru = new LRUCache(input[i][0]);
				output[i] = null;
			} else if (operation[i].equals("put")) {
				lru.put(input[i][0], input[i][1]);
				output[i] = null;
			} else {
				//System.out.println(lru.get(input[i][0]));
				output[i] = lru.get(input[i][0]);
			}
		}

		System.out.println("null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5");
		for (Integer i : output) {
			System.out.print(i + ",");
		}
		System.out.print("\nlru : ");
		for(int i : lru.theCache.keySet()) {
			System.out.print( i + "  " );
		}

		/*System.out.print("\n DLL : ");
		DLinkedListNode node = lru.dll.mostRecentlyUsed;
		while(node.next != null) {
			System.out.print(node.key+ "  ");
			node = node.next;
		}*/
	}
}
