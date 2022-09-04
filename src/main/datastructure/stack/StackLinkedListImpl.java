package main.datastructure.stack;

import java.util.Scanner;

public class StackLinkedListImpl {
	public static void main(String[] args) {
		StackLinkedList llist = new StackLinkedList();
		llist.add(7);
		llist.add(1);
		llist.add(3);
		llist.add(2);
		llist.add(8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		System.out.println("\nAfter first delete :  ");
		llist.delete();
		llist.printList();

		System.out.println("\nAfter 2nd delete :  ");
		llist.delete();
		llist.printList();

		System.out.println("\nAfter 3rd delete :  ");
		llist.delete();
		llist.printList();

		System.out.println("\nAfter 4th delete :  ");
		llist.delete();
		llist.printList();

		System.out.println("\nAfter 5th delete :  ");
		llist.delete();
		llist.printList();

		System.out.println("\nAfter 6th delete :  ");
		llist.delete();
		llist.printList();
	}
}
