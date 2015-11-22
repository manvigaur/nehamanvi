package com.list;

public class LinkList {
	public Node first;
	public Node last;

	public void insertEnd(int paramInt) {
		Node localNode = new Node();
		if (first == null) {
			first = localNode;
		} else {
			last.next = localNode;
		}
		localNode.data = paramInt;
		last = localNode;
	}

	public void insertBegin(int paramInt) {
		Node localNode = new Node();
		localNode.next = first;
		if (first == null) {
			last = localNode;
		}
		first = localNode;
		localNode.data = paramInt;
	}

	public void deleteBegin() {
		if (first == null) {
			return;
		}
		first = first.next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public boolean isFull() {
		return size() == 20;
	}

	public int size() {
		int i = 0;
		Node localNode = first;
		while (localNode != null) {
			i++;
			localNode = localNode.next;
		}
		return i;
	}
}
