/*
LeetCode #206: Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/

Easy | Linked List | Recursion | Iteration

Two Approaches:
1. Iterative - O(n) time, O(1) space
2. Recursive - O(n) time, O(n) stack space
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Approach-1:
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp= front;
        }
        return prev;

    }
}


//Approach-2:
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }
}
