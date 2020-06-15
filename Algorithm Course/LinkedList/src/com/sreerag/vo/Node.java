package com.sreerag.vo;

public class Node<E> {

	public Node<E> next;
	public E data;
	
	public Node(E data) 
	{
		this.setData(data);
		next = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		StringBuilder br = new StringBuilder();
		while(next != null)
		{
			br.append(next.getData() + "--");
			next = next.next;
		}
		return br.toString();
	}
	
}
