package com.sreerag.vo;

public class SingleLinkedList<E> extends LinkedList<E> {

	Node<E> head;
	
	Node<E> tail;
	
	int size;
	
	public SingleLinkedList() {
	
	}
	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public synchronized Node<E> createLinkedList(E value) {
		
		Node<E> node = new Node<E>(value);
		node.next = null;
		head = node;
		tail = node;
		size = 1;
		return node;
	}

	public synchronized void insert(E value) {
		
		insertLinkedList(value, size);
	}
	
	@Override
	public synchronized void insertLinkedList(E value, int position) {
		
		if(!exists()) return;	
		Node<E> node = new Node<E>(value);
		if(position == 0)
		{
			
			node.next = head;
			head = node;
			
		}
		else
			if(position >= size)
			{
				node.next = null;
				tail.next = node;
				tail = node;
			}
			else
			{
				int currentposition = 0;
				Node<E> pointer = head;
				
				while(pointer != null)
				{
					if(currentposition == position  - 1)
					{
						
						node.next = pointer.next;
						pointer.next = node;
						
					}
					pointer = pointer.next;
					currentposition++;
				}
			}
		
		setSize(getSize() + 1);
		
		
	}

	@Override
	public synchronized boolean exists() {

		return head != null;
	}

	@Override
	public synchronized void reverseLinkedList() {
		
		
		if(exists())
		{
			Node<E> prev = null;
			Node<E> current = head;
			Node<E> next = null;
			
			// null || 40 - 10 - 10 || null
			// 40 - null || 10 - 10 -null || 10 10
			// 10 - 40 - null || 10 -  null|| 10 - null
			// 10 - 10 - 40 - null|| null || null
			while(current != null)
			{
				next = current.next;
				current.next = prev;		
				prev = current;
				current = next;
				tail = next;
			}
			tail = head;
			tail.next = null;
			head = prev; 
		}
		
	}

	@Override
	public synchronized void deleteLinkedList() {
		
		head = null;
		tail = null;
		
	}

	@Override
	public synchronized int searchNode(E value) {
		
		Node<E> pointer = head;
		int index = 0;
		while(pointer != null)
		{
			if(pointer.data == value)
			{
				return index;
			}
			index++;
			pointer = pointer.next;
		}
		return -1;
	}

	@Override
	public synchronized void deletionOfNode(int location) {
		
		// 2 5 7 1 5
		// 1
		if(location == 0)
		{
			head = head.next;	
		}
		else
		{
			if(location > size - 1)
				location = size - 1;
			
			Node<E> pointer = head;
			int current = 0;
			
			while(pointer != null)
			{
				if(location - 1 == current && pointer.next != null)
				{
					pointer.next = pointer.next.next;
					if(location == size - 1)
						tail = pointer;
					
					
				}
				else
					pointer = pointer.next;
				current++;
			}
		}
		
		setSize(getSize()-1);
	}
	
	@Override
	public synchronized void traverse() {
		
		Node<E> pointer = head;
		
		while(pointer != null)
		{
			System.out.print(pointer.data + "--> ");
			pointer = pointer.next;
		}
		System.out.print("null \n");
	}
	
	@Override
	public synchronized void traverseTail() {
		
		Node<E> pointer = tail;
		System.out.print("Tail - ");
		while(pointer != null)
		{
			System.out.print(pointer.data + "--> ");
			pointer = pointer.next;
		}
		System.out.print("null \n");
	}
	
	@Override
	public synchronized void deletionOfMiddleNode() {
	
		deletionOfNode(size / 2);
	}

}
