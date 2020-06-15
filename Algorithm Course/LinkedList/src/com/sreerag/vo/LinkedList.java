package com.sreerag.vo;

public abstract class LinkedList<E> {
	
	Node<E> head;
	
	Node<E> tail;
	
	int size;
	
	abstract Node<E> createLinkedList(E value);
	
	abstract void insertLinkedList(E value, int position);
	
	abstract boolean exists();
	
	abstract void reverseLinkedList();
	
	abstract void traverse();
	
	abstract void deleteLinkedList();
	
	abstract int searchNode(E value);
	
	abstract void deletionOfNode(int location);
	
	abstract void deletionOfMiddleNode();
	
	abstract void traverseTail();
}
