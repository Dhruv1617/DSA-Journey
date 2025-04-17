/*
LeetCode #141: Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/

Easy | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach: Use Floyd’s Tortoise and Hare Algorithm to detect cycle in O(1) space.
If fast and slow pointers meet, a cycle exists.
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
