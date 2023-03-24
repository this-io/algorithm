package implementation.medium.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> perimeterNodes = new ArrayList<>();

    public static void main(String[] args) {
        BoundaryOfBinaryTree b = new BoundaryOfBinaryTree();
        b.boundaryOfBinaryTree(null);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        perimeterNodes.add(root.val);
        leftSide(root.left);
        leaves(root.left);
        leaves(root.right);
        rightSide(root.right);

        return perimeterNodes;
    }

    private void leftSide(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) {
            return;
        }

        perimeterNodes.add(node.val);
        if(node.left == null) {
            leftSide(node.right);
        } else {
            leftSide(node.left);
        }
    }

    private void rightSide(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) {
            return;
        }
        if(node.left == null) {
            rightSide(node.right);
        } else {
            rightSide(node.left);
        }
        perimeterNodes.add(node.val);
    }

    private void leaves(TreeNode node) {
        if(node == null) {
            return;
        }

        if(node.right == null && node.left == null) {
            perimeterNodes.add(node.val);
            return;
        }

        leaves(node.left);
        leaves(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
