package com.sreerag.problems;

import java.util.HashSet;

import com.sreerag.helper.LinkedLLHelper;
import com.sreerag.vo.Node;
import com.sreerag.vo.SingleLinkedList;

public class DeDupe<E> extends LinkedLLHelper<E>{

	@Override
	public void dedupe(SingleLinkedList<E> list) {
		
		Node<E> head = list.getHead();
		Node<E> pointer = head;
		Node<E> prev = head;
		HashSet<E> set = new HashSet<>();
		
		while(pointer != null)
		{
			E value = pointer.getData();
			if(set.contains(value) && prev.next != null)
			{
				prev.next = prev.next.next;
			}
			else
			{
				set.add(value);
			}
			prev = pointer;
			pointer = pointer.next;
		}
		
		
	}
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.createLinkedList(5);
		list.insert(10);
		list.insert(20);
		list.insert(40);
		list.insert(10);
		list.insert(30);
		list.insert(10);
		list.traverse();
		
		LinkedLLHelper<Integer> helper = new DeDupe<Integer>();
		helper.dedupe(list);
		
		list.traverse();
		
	}
}
