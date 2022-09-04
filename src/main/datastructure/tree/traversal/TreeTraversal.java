package main.datastructure.tree.traversal;

public class TreeTraversal {
	Node root;

	public TreeTraversal() {
		this.root = null;
	}

	public static void inorder(Node node) {
		if(node == null) {
			return;
		}

		inorder(node.left);

		System.out.print(node.key + "  ");

		inorder(node.right);
	}

	public static void preorder(Node node) {
		if(node == null) {
			return;
		}

		System.out.print(node.key + "  ");

		preorder(node.left);
		preorder(node.right);
	}

	public static void postorder(Node node) {
		if(node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key + "  ");
	}

	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("\nPrint inorder");
		inorder(tree.root);

		System.out.println("\nPrint Pre order");
		preorder(tree.root);

		System.out.println("\nPrint Post order");
		postorder(tree.root);
	}
}
