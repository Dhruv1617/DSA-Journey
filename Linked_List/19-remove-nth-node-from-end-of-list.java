/*
LeetCode #19: Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Medium | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach:
- Use two pointers (fast and slow).
- Move fast pointer `n` steps ahead.
- Then move both pointers until fast reaches the end.
- Now slow is just before the node to delete.
- If fast becomes null after initial move, we are deleting the head node.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null){
            head = head.next;
            return head;
        }
        while(fast.next!=null ){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
        
    }
}
