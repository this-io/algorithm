package datastructure.tree.binarytree.linkedlist;

import datastructure.tree.binarytree.BinaryTree;
import datastructure.tree.binarytree.Node;

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
