package implementation.hard;

import java.util.*;

public class MaxStack {
    public static void main(String[] args) {
        //String[] ops = {"MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"};
        //int[][] inps = {{}, {5}, {1}, {5}, {}, {}, {}, {}, {}, {}};

        //String[] ops = {"MaxStack","push","push","popMax","peekMax"};
        //int[][] inps = {{},{5},{1},{},{}};

        //String[] ops = {"MaxStack", "push", "peekMax", "push", "peekMax", "push", "pop", "pop", "push", "peekMax", "push", "popMax", "top", "push", "push", "peekMax", "popMax", "popMax"};
        //int[][] inps = {{}, {92}, {}, {54}, {}, {22}, {}, {}, {-57}, {}, {-24}, {}, {}, {26}, {-71}, {}, {}, {}};

        String[] ops = {"MaxStack","push","push","push","pop","peekMax","top"};
        int[][] inps = {{},{5},{1},{5},{},{},{}};

        MaxStack maxStack = new MaxStack();
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (String op : ops) {
            if (op.equalsIgnoreCase("MaxStack")) {
                maxStack = new MaxStack();
                result.add(null);
            } else if (op.equalsIgnoreCase("push")) {
                maxStack.push(inps[counter][0]);
                result.add(null);
            } else if (op.equalsIgnoreCase("top")) {
                result.add(maxStack.top());
            } else if (op.equalsIgnoreCase("popMax")) {
                result.add(maxStack.popMax());
            } else if (op.equalsIgnoreCase("peekMax")) {
                result.add(maxStack.peekMax());
            } else if (op.equalsIgnoreCase("pop")) {
                result.add(maxStack.pop());
            }
            counter++;
        }
        System.out.println();
        System.out.println();
        for (Integer i : result) {
            System.out.print(i + "  ");
        }
    }

    Stack<Integer> s;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MaxStack() {
        s = new Stack<Integer>();
        pq = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
    }

    public void push(int x) {
        s.push(x);
        pq.offer(x);
    }

    public int pop() {
        int pop = s.pop();
        pq.remove(pop);
        return pop;
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int max = pq.poll();
        Stack<Integer> sp = new Stack<Integer>();
        while (!s.isEmpty()) {
            if (s.peek() != max) {
                sp.push(s.pop());
            } else {
                s.pop();
                break;
            }
        }
        while (!sp.isEmpty()) {
            s.push(sp.pop());
        }
        return max;
    }

    /*Node head;
    Node tail;
    PriorityQueue<Node> thePriorityQ;
    PriorityQueue<Integer> thePQ = new PriorityQueue<>(Collections.reverseOrder());

    public MaxStack() {
        head = new Node((10 ^ -7) - 1);
        head.previous = null;
        thePriorityQ = new PriorityQueue<Node>((10 ^ 7), new PriorityQComparator());
    }

    public void push(int x) {
        Node node = new Node(x);
        if (tail == null) {
            node.previous = head;
            head.next = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        thePriorityQ.add(node);
        thePQ.add(x);
    }

    public int pop() {
        Node theTail = tail;

        if (tail.val == thePriorityQ.peek().val) {
            thePriorityQ.remove();
        } else {
            thePriorityQ.remove(theTail);
        }

        Node previousToTail = tail.previous;
        tail.previous.next = null;
        tail.previous = null;
        tail = previousToTail;

        return theTail.val;
    }

    public int top() {
        return tail.val;
    }

    public int peekMax() {
        return thePriorityQ.peek().val;
    }

    public int popMax() {
        int returnVal = thePriorityQ.peek().val;

        if (tail.val == thePriorityQ.peek().val) {
            Node previousToTail = tail.previous;
            tail.previous.next = null;
            tail.previous = null;
            tail = previousToTail;
            thePriorityQ.remove();
        } else {
            Node theMax = thePriorityQ.remove();
            Node previousToMax = theMax.previous;
            Node nextToMax = theMax.next;

            if (previousToMax != null && previousToMax.next != null) {
                previousToMax.next = nextToMax;
            }
            //previousToMax.next = nextToMax;
            if (nextToMax != null && nextToMax.previous != null) {
                nextToMax.previous = previousToMax;
            }
        }
        return returnVal;
    }

    class Node {
        public int val;
        public Node next;
        public Node previous;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }

    class PriorityQComparator implements Comparator<Node> {
        public int compare(Node o1, Node o2) {
            if (o1.val <= o2.val) {
                return 1;
            } else if (o1.val > o2.val) {
                return -1;
            }
            return 0;
        }
    }*/
}
