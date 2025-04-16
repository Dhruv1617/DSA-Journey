/*
LeetCode #876: Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/

Easy | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach: Use slow and fast pointers. When fast reaches end, slow is at middle.
If even number of nodes, returns the 2nd middle node as required.
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
    public ListNode middleNode(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

