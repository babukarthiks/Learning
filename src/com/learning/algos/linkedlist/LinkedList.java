/**
 *
 */
package com.learning.algos.linkedlist;

import com.learning.ds.pojos.SingleLinkedListNode;

/**
 * @author ks044388
 *
 */
public class LinkedList {

	SingleLinkedListNode head;

	public void insertAtFirst(int value) {
		if (head == null) {
			head = new SingleLinkedListNode(value);
		} else {
			SingleLinkedListNode node = new SingleLinkedListNode(value);
			node.setNext(head);
			head = node;
		}
	}

	public void insertAfter(int value, int afterValue) throws Exception {

		if (head == null) {
			throw new Exception("value to insert after doesnt exist");
		} else {
			SingleLinkedListNode node = head;
			boolean inserted = false;
			while (node.getNext() != null) {
				if (node.getValue() == afterValue) {
					SingleLinkedListNode newNode = new SingleLinkedListNode(value);
					newNode.setNext(node.getNext());
					node.setNext(newNode);
					inserted = true;
					break;
				}
				node = node.getNext();
			}
			if (!inserted) {
				throw new Exception("value to insert after doesnt exist");
			}
		}
	}

	public void insertAtEnd(int value) {
		if (head == null) {
			insertAtFirst(value);
		} else {
			SingleLinkedListNode node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			SingleLinkedListNode newNode = new SingleLinkedListNode(value);
			node.setNext(newNode);
		}
	}

	public int lengthIterative() {
		if (head == null)
			return 0;
		int length = 1;
		SingleLinkedListNode n = head;
		while (n.getNext() != null) {
			length++;
		}
		return length;
	}

	public int lengthRec() {
		if (head == null)
			return 0;
		return lengthRecursive(head);
	}

	public int lengthRecursive(SingleLinkedListNode n) {
		if (n.getNext() == null) {
			return 0;
		}
		return 1 + lengthRecursive(n.getNext());
	}

	public void swapNodes(int x, int y) {

		SingleLinkedListNode start = head, nodeForX = null, nodeBeforeX = null, nodeForY = null, nodeBeforeY = null;
		// nothing to swap, if same value
		if (x == y) {
			return;
		}
		while (start.getNext() != null) {
			if (start.getNext().getValue() == x) {
				nodeForX = start.getNext();
				nodeBeforeX = start;
			}
			if (start.getValue() == y) {
				nodeForY = start.getNext();
				nodeBeforeY = start;
			}
			// no need search futher, already found both nodes
			if (nodeForX != null && nodeForY != null)
				break;
			start = start.getNext();
		}
		// if any of the node is not found
		if (nodeForX == null || nodeForY == null) {
			return;
		}

		// if x is head
		if (nodeForX == head) {
			head = nodeForY;
		} else {
			nodeBeforeX.setNext(nodeForY);
		}

		// if y is head
		if (nodeForY == head) {
			head = nodeForX;
		} else {
			nodeBeforeY.setNext(nodeForX);
		}

		// swap nodes
		SingleLinkedListNode temp = nodeForX;
		nodeForX = nodeForY;
		nodeForY = temp;

	}

	// need to review
	public int findNth(int x) {
		SingleLinkedListNode current = head;
		SingleLinkedListNode currentNext = null;

		if (head.getNext() != null) {
			currentNext = head.getNext();
		} else {
			if (x > 0) {
				return 0;
			}
			return head.getValue();
		}

		int currentIndex = 0, currentToNextIndex = 1;

		while (current != null) {
			if (currentIndex == x) {
				return current.getValue();
			}
			if (currentToNextIndex == x) {
				return currentNext.getValue();
			}
			currentIndex = currentIndex + 2;
			currentToNextIndex = currentToNextIndex + 2;
			current = current.getNext().getNext();
			currentNext = currentNext.getNext().getNext();
		}
		return -1;
	}

	SingleLinkedListNode InsertNth(SingleLinkedListNode head, int data, int position) {
		SingleLinkedListNode node = new SingleLinkedListNode(data);
		// node.data = data;
		node.setNext(null);

		if (head == null) {
			if (position == 0) {
				head = node;
				return head;
			}
		}
		int currPosition = 0;
		SingleLinkedListNode currNode = head;
		while (currNode.getNext() != null && currPosition != position) {
			currNode = currNode.getNext();
			currPosition++;
		}
		if (currPosition == position) {
			if (currNode.getNext() == null) {
				currNode.setNext(node);

			} else {
				node.setNext(currNode.getNext());
				currNode.setNext(node);
			}
		}
		return head;
	}
}
