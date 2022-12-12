package implementation.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreeLevelOrderTraversal {
    Stack<Integer> theStack = new Stack<>();

    public static void main(String[] args) {

    }


    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
