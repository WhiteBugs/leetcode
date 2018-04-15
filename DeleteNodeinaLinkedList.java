package com.leetcode;

import com.leetcode.elements.ListNode;

/**
 * Create by WhiteBugs .
 */
public class DeleteNodeinaLinkedList {

    //237. Delete Node in a Linked List
    //https://leetcode.com/problems/delete-node-in-a-linked-list/description/

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
