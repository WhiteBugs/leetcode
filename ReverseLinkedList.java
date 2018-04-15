package com.leetcode;

import com.leetcode.elements.ListNode;

/**
 * Create by WhiteBugs .
 */
public class ReverseLinkedList {

    //206. Reverse Linked List
    //https://leetcode.com/problems/reverse-linked-list/description/

    /*
	 * public ListNode reverseList(ListNode head) {//iteratively version
    	if(head == null)
    		return head;
        ListNode  node = head.next , temp=null;
        head.next=null;
        while(node!=null){
        	temp = node.next;
        	node.next = head;
        	head = node;
        	node = temp;
        }
        return head;
    }
	 */

    private ListNode head = null;

    public ListNode reverseList(ListNode head) {//recursively version
        reverseList(head.next, head);
        return head;
    }

    public ListNode reverseList(ListNode node, ListNode head) {
        if (node == null)
            return null;
        if (node.next == null) {
            this.head = node;
            return node;
        }
        reverseList(node.next, head).next = node;
        return node;
    }
}

