/*
LeetCode #53: Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

Medium| Arrays | Dynamic Programming | Greedy | Divide and Conquer

Time: O(n)
Space: O(1)

Kadane's Algorithm: Track current sum, reset if negative.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for(int i :nums){
            count+=i;
            maxCount = Math.max(maxCount, count);

            if(count<0){
                count = 0;
            }
        }
        return maxCount;
    }
}
