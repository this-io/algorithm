package implementation.easy.rangesumofbst;

public class BinaryTree {
	//TreeNode root;

	public TreeNode insert(TreeNode root, Integer val) {
		if (val != null) {
			if (root == null) {
				return new TreeNode(val);

			}

			if (root.val < val) {
				root.right = insert(root.right, val);
			} else if (root.val > val) {
				root.left = insert(root.left, val);
			}
		}
		return root;
	}

	/*public TreeNode insert(TreeNode root, Integer key) {
		if (key != null) {
			// if the root is null, create a new node and return it
			if (root == null) {
				return new TreeNode(key);
			}

			// if the given key is less than the root node,
			// recur for the left subtree
			if (key < root.val) {
				root.left = insert(root.left, key);
			}

			// otherwise, recur for the right subtree
			else {
				// key >= root.data
				root.right = insert(root.right, key);
			}
		}
		return root;
	}*/

	public static void inorder(TreeNode root) {
		if (root == null) {
			return ;
		}

		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);

		//return result;
	}
}
