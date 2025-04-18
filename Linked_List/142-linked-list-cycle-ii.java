/*
LeetCode #142: Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/

Medium | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach: Floyd’s Cycle Detection (Tortoise & Hare).
Once a cycle is detected, reset one pointer to head and move both one step at a time until they meet. That meeting point is the start of the cycle.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
