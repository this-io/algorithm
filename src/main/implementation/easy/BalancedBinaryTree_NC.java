package main.implementation.easy;

public class BalancedBinaryTree_NC {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        return false;
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