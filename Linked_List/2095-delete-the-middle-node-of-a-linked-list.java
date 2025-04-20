/*
LeetCode #2095: Delete the Middle Node of a Linked List
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Medium | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach:
- Use slow and fast pointers to find the middle node.
- Slow will stop one node before the middle.
- Delete middle by: slow.next = slow.next.next
- Handle edge case where head has only one node: return null.
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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = slow.next.next;
        middle.next = null;
        return head;

    }
}
