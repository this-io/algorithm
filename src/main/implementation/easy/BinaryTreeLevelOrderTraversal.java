package main.implementation.easy;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    //private Queue<TreeNode> theQueue = new ArrayDeque<>();
    public static void main(String[] args) {
        Tree tree = new Tree();
        int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);
        tree.inOrder(tree.root);

        BinaryTreeLevelOrderTraversal btlt = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = btlt.levelOrder(tree.root);

        for (List<Integer> i : result) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(1);//start from 1

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int level = levelQueue.poll();

            List<Integer> l = null;
            if (result.size() < level) {
                l = new ArrayList<>();
                result.add(l);
            } else {
                l = result.get(level - 1);
            }

            l.add(node.val);

            if (node.left != null) {
                nodeQueue.offer(node.left);
                levelQueue.offer(level + 1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        return result;
    }

    public static class TreeNode {
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

    public static class Tree {
        TreeNode root;

        // Function to insert nodes in level order
        public TreeNode insertLevelOrder(int[] arr, TreeNode root,
                                         int i) {
            // Base case for recursion
            if (i < arr.length) {
                TreeNode temp = new TreeNode(arr[i]);
                root = temp;

                // insert left child
                root.left = insertLevelOrder(arr, root.left,
                        2 * i + 1);

                // insert right child
                root.right = insertLevelOrder(arr, root.right,
                        2 * i + 2);
            }
            return root;
        }

        // Function to print tree nodes in InOrder fashion
        public void inOrder(TreeNode root) {
            if (root != null) {
                inOrder(root.left);
                //System.out.print(root.val + " ");
                inOrder(root.right);
            }
        }
    }
}
