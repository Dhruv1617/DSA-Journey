/*
LeetCode #213: House Robber II
https://leetcode.com/problems/house-robber-ii/

Medium | Dynamic Programming

Problem
-------
You are a professional robber planning to rob houses along a street arranged in a circle.
- Each house has some money.
- Adjacent houses cannot be robbed on the same night.
- The first house is also adjacent to the last house.

Return the maximum amount of money you can rob without alerting the police.

Examples
--------
Input: nums = [2,3,2]
Output: 3
Explanation: Rob house 2 (3).

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 2 (2) + house 4 (1).

Approach
--------
- Circle arrangement means you cannot rob both the first and the last house.
- Reduce to two cases:
    1. Rob houses from index 0 to n-2.
    2. Rob houses from index 1 to n-1.
- Take the maximum of the two.
- Each case is solved using the space-optimized DP approach (like House Robber I).

Time: O(n)
Space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Option 1: Rob houses 0..n-2
        int option1 = robLinear(nums, 0, n - 2);

        // Option 2: Rob houses 1..n-1
        int option2 = robLinear(nums, 1, n - 1);

        return Math.max(option1, option2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev = 0;   // dp[i-1]
        int prev2 = 0;  // dp[i-2]
        
        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}


