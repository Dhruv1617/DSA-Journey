/*
LeetCode #234: Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/

Easy | Linked List | Two Pointers

Time: O(n)
Space: O(1)

Approach:
1. Use slow & fast pointers to reach the middle.
2. Reverse second half of the list.
3. Compare first half and reversed second half.
4. (Optional) Restore the list if needed.
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
    public static ListNode reverse(ListNode head){
        ListNode temp  = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
        }
        ListNode newHead = reverse(slow);
       

        ListNode temp1 = head;
        ListNode temp2 = newHead;

        while( temp2!=null){
            if(temp1.val != temp2.val){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;

    }
}
