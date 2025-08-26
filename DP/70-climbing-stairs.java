/*
LeetCode #70: Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

Easy | Dynamic Programming

Problem
-------
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps.
Return the number of distinct ways to reach the top.

Examples
--------
Input: n = 2
Output: 2
Explanation: 1+1, 2

Input: n = 3
Output: 3
Explanation: 1+1+1, 1+2, 2+1

Approach
--------
This is equivalent to the Fibonacci sequence:
ways(n) = ways(n-1) + ways(n-2)

We use a **space-optimized DP** approach:
- Track only the last two states (`prev1`, `prev2`).
- Time: O(n)
- Space: O(1)
*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}



