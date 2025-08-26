/*
LeetCode #62: Unique Paths
https://leetcode.com/problems/unique-paths/

Medium | Dynamic Programming

Problem
-------
A robot is located at the top-left corner of an m x n grid.
- The robot can move only right or down.
- It must reach the bottom-right corner.

Return the number of unique paths to reach the bottom-right.

Constraints
-----------
1 <= m, n <= 100
Answer <= 2 * 10^9

Examples
--------
Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3

Approach
--------
- Use dynamic programming:
  dp[i][j] = dp[i-1][j] + dp[i][j-1]
- Space optimization: keep only current row and previous row.

Time:  O(m * n)
Space: O(n)
*/


class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = i > 0 ? prev[j] : 0;
                int left = j > 0 ? temp[j - 1] : 0;
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}


