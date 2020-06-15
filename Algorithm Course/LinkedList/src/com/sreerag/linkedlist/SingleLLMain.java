package com.sreerag.linkedlist;

import com.sreerag.vo.SingleLinkedList;

public class SingleLLMain {

public static void main(String[] args) {
		
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.createLinkedList(5);
		list.traverse();
		list.insertLinkedList(10, 1);
		list.traverse();
		
		list.insertLinkedList(20, 2);
		list.traverse();
		
		list.insertLinkedList(10, 1);
		list.traverse();
		
		list.insertLinkedList(20, 2);
		list.traverse();
		
		list.insertLinkedList(30, 2);
		list.traverse();
		
		list.insertLinkedList(40, 1);
		list.traverse();
		
		list.traverse();
		System.out.println();
		
		System.out.println("\nSearching the node having value 40...");
		System.out.println(list.searchNode(40));

		System.out.println("\nSearching the node having value 500...");
		System.out.println(list.searchNode(500));
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deletionOfNode(0);
		System.out.println("After Deletion:");
		list.traverse();
		System.out.println();
		
		System.out.println("\n\nDeleting the node having location = 3: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deletionOfNode(3);
		System.out.println("After Deletion:");
		list.traverse();
		list.traverseTail();
		System.out.println();
		
		System.out.println("\n\nDeleting the node having location = 100: ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deletionOfNode(100);
		System.out.println("After Deletion:");
		list.traverse();
		list.traverseTail();
		System.out.println();
		
		System.out.println("\n\nDeleting the middle node ");
		System.out.println("Before Deletion:");
		list.traverse();
		list.deletionOfMiddleNode();
		System.out.println("After Deletion:");
		list.traverse();
		list.traverseTail();
		System.out.println();
		
		System.out.println("Reverse LL:");
		list.reverseLinkedList();
		list.traverse();
		list.traverseTail();
		//list.deleteLinkedList();
		//list.traverse();
		
	}
}
