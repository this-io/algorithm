package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> theQueue = new ArrayDeque();
        List<List<Integer>> result = new ArrayList<>();

        theQueue.add(root);

        while (!theQueue.isEmpty()) {
            int currentQSize = theQueue.size();
            List<Integer> level = new ArrayList<>();

            //This for loop helps to go level by level because, we are popping every node in the current level and
            // adding all the children to the queue.
            for (int i = 0; i < currentQSize; i++) {
                TreeNode theNode = theQueue.remove();
                if(theNode != null) {
                    level.add(theNode.val);
                    theQueue.add(theNode.left);
                    theQueue.add(theNode.right);
                }
            }

            if(level.size() > 0) {
                result.add(level);
            }
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
