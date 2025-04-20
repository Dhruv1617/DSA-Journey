/*
LeetCode #328: Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/

Medium | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach:
- Use two pointers: odd and even.
- Traverse the list while separating odd and even indexed nodes.
- Reconnect the even list after the odd list.
- Keep relative order of odd and even groups.
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode secondNode = head.next;
        ListNode even = head.next;
        while(even !=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even  = even.next;

        }
        odd.next = secondNode;
        return head;
    }
}
