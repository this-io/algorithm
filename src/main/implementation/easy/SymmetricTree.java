package main.implementation.easy;

import main.implementation.easy.tree.SameTree;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        isMirror(root, root);
        return false;
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        //return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        return false;
    }

    public class TreeNode {
        int val;
        SameTree.TreeNode left;
        SameTree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, SameTree.TreeNode left, SameTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
