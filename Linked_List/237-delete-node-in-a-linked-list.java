/*
LeetCode #237: Delete Node in a Linked List
https://leetcode.com/problems/delete-node-in-a-linked-list/

Medium | Linked List

Time: O(1)
Space: O(1)

Trick: Copy value from next node and bypass it.
Note: You are not given the head of the list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val  = node.next.val;
        node.next = node.next.next;
    }
}
