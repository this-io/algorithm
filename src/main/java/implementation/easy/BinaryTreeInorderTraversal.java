package implementation.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);

        bt.inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        inorder(root, op);

        for(Integer i : op) {
            System.out.println(i);
        }
        return op;
    }

    public void inorder(TreeNode node, List<Integer> op) {
        if(node == null) {
            return;
        }

        inorder(node.left, op);
        op.add(node.val);
        inorder(node.right, op);
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        postOrder(root, op);
        return op;
    }

    public void postOrder(TreeNode node, List<Integer> op) {
        if(node == null) {
            return;
        }
        postOrder(node.left, op);
        postOrder(node.right, op);
        op.add(node.val);
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        preOrder(root, op);
        return op;
    }

    public void preOrder(TreeNode node, List<Integer> op) {
        if (node == null) {
            return;
        }

        op.add(node.val);
        preOrder(node.left, op);
        preOrder(node.right, op);
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
}
