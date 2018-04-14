package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class AddTwoNumbers {

    //2. Add Two Numbers
    //https://leetcode.com/problems/add-two-numbers/description/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode answer = temp;
        int carry = 0;
        while(l1!=null || l2!=null||carry!=0){
            temp.next = new ListNode(0);
            temp = temp.next;
            if(l1==null)
                l1 = new ListNode(0);
            if(l2==null)
                l2 = new ListNode(0);
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            temp.val = sum%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        return answer.next;
    }
}
