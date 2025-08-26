/*
LeetCode #198: House Robber
https://leetcode.com/problems/house-robber/

Medium | Dynamic Programming

Problem
-------
You are a professional robber planning to rob houses along a street. Each house has a certain
amount of money. Adjacent houses cannot be robbed on the same night (security systems trigger).

Return the maximum amount of money you can rob without alerting the police.

Examples
--------
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (1) and house 3 (3).

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (2), house 3 (9), house 5 (1).

Approach
--------
Dynamic Programming:
- At each house, you decide to "pick" (rob current + dp[i-2]) or "not pick" (dp[i-1]).
- Space optimized using two variables:
    prev  = dp[i-1]
    prev2 = dp[i-2]

Time: O(n)
Space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];   // dp[i-1]
        int prev2 = 0;        // dp[i-2]

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = prev;

            int cur = Math.max(pick, notPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}




