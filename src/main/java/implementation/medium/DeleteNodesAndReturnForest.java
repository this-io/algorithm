package implementation.medium;

import java.util.List;

public class DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        DeleteNodesAndReturnForest df = new DeleteNodesAndReturnForest();
        int[] input = {1,2,3,4,5,6,7};
        int[] to_delete = {3,5};

        TreeNode root = df.constructTree(input);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        return null;
    }

    public TreeNode constructTree(int[] input) {
        if(input.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(input[0]);
        for(int i=0; i<input.length; i++) {
            if(root == null) {
                break;
            }

        }

        return root;
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
