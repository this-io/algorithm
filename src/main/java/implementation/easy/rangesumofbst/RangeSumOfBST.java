package implementation.easy.rangesumofbst;

public class RangeSumOfBST {
	int result;
	public static void main(String[] args) {
		RangeSumOfBST r = new RangeSumOfBST();
		BinaryTree tree = new BinaryTree();
		Integer[] elements = {10,5,15,3,7,null,18};
		TreeNode root = null;
		for(Integer i : elements) {
			root = tree.insert(root, i);
		}
		System.out.println(r.rangeSumBST(root, 7, 15));

	}

	private int rangeSumBST(TreeNode root, int low, int high) {
		if(root == null) {
			return 0;
		}

		if(root.val >= low && root.val <= high) {
			result += root.val;
		}
		if(low < root.val) {
			rangeSumBST(root.left, low, high);
		}

		if(high > root.val) {
			rangeSumBST(root.right, low, high);
		}

		return result;
	}
}
