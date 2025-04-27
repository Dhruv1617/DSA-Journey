/*
LeetCode #2149: Rearrange Array Elements by Sign
https://leetcode.com/problems/rearrange-array-elements-by-sign/

Medium | Array, Two Pointers, Simulation

Time: O(n)
Space: O(n)

Approach:
- Use two pointers:
    - 'pos' to place positive numbers at even indices.
    - 'neg' to place negative numbers at odd indices.
- Traverse the array once and fill a new array following the rules.
- As the number of positives and negatives is equal, this strategy works perfectly.
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0;i<n;i++){
            if(nums[i]>0){
                arr[pos] = nums[i];
                pos+=2;
            }else{
                arr[neg] = nums[i];
                neg+=2;
            }
        }
        
        return arr;
    }
}
