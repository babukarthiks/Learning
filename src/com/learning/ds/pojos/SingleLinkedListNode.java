package com.learning.ds.pojos;

public class SingleLinkedListNode {

	int value;
	SingleLinkedListNode next;

	public SingleLinkedListNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SingleLinkedListNode getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}

}
