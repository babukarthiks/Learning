package com.learning.algos.linkedlist;

import com.learning.ds.pojos.SingleLinkedListNode;

public class ReverseEveryKNodes {

    public SingleLinkedListNode reverseEveryKNodes(SingleLinkedListNode head, int k) {

        // assuming k is always less than list size

        reverseNodes(head, k);

        return null;
    }

    private static SingleLinkedListNode reverseNodes(SingleLinkedListNode head, int k) {

        while (k > 0) {
            SingleLinkedListNode temp = head;
            if (head.getNext() != null) {
                head = head.getNext();
                head.setNext(temp);
            }
            k--;
        }
        return head;
    }
    
    
    public static void main(String[] args) {
        SingleLinkedListNode node3 = new SingleLinkedListNode(3);
        SingleLinkedListNode node2 = new SingleLinkedListNode(2);
        SingleLinkedListNode node1 = new SingleLinkedListNode(1);
        node1.setNext(node2);
        node2.setNext(node3);
        reverseNodes(node1,3);
    }

}
