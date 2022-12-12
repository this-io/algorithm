package datastructure.tree.binarytree;

public class Node {
	private int data;
	private Node lChild;
	private Node rChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLChild() {
		return lChild;
	}

	public void setLChild(Node lChild) {
		this.lChild = lChild;
	}

	public Node getRChild() {
		return rChild;
	}

	public void setRChild(Node rChild) {
		this.rChild = rChild;
	}

}
