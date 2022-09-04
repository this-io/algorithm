package main.datastructure.tree.binarytree.linkedlist;

import main.datastructure.tree.binarytree.BinaryTree;
import main.datastructure.tree.binarytree.Node;

public class BinaryTreeLinkedListImpl implements BinaryTree {
	Node root;
	@Override
	public void insert(int data) {
		Node item = new Node();
		if(root == null) {
			item.setData(data);
		} else {
			
		}
	}

	@Override
	public void search(int item) {

	}

	@Override
	public void delete(int data) {

	}
}
