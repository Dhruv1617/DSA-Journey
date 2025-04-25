/*
LeetCode #25: Reverse Nodes in k-Group
https://leetcode.com/problems/reverse-nodes-in-k-group/

Hard | Linked List

Time: O(n)
Space: O(1)

Approach:
- Traverse the list in chunks of k nodes.
- For each k-group, detach it, reverse it, then reattach to the previous segment.
- Carefully manage links using helper methods: reverse() and getKthNode().
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
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp  = front;
        }
        return prev;
    
    }
    public static ListNode getKthNode(ListNode temp, int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        
        ListNode prevLast = null;
        while(temp!=null){
            ListNode kThNode = getKthNode(temp, k);
            if(kThNode==null){
                if(prevLast!=null){
                    prevLast.next = temp;
                }
                break;
            }
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            reverse(temp);

            if(temp == head){
                head = kThNode;
            }else{
                
                prevLast.next = kThNode;
                
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
        
        

    }
}
