/*
LeetCode #148: Sort List
https://leetcode.com/problems/sort-list/

Medium | Linked List | Merge Sort | Divide and Conquer

Time: O(n log n)
Space: O(log n) - due to recursive call stack

Approach:
- Use merge sort to sort the linked list.
- Recursively divide the list into two halves using the slow/fast pointer technique.
- Sort both halves, then merge them using a helper function.
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
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1!=null){
            temp.next = list1;
            
        }
       else{
            temp.next = list2;
            
        }
        return dummyNode.next;
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right); 
    }
}
