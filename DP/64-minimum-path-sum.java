/*
LeetCode #64: Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/

Medium | Dynamic Programming

Problem
-------
Given a grid filled with non-negative numbers, find a path from top-left 
to bottom-right which minimizes the sum of numbers along the path.
You can only move right or down.

Constraints
-----------
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100

Examples
--------
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Path is 1 → 3 → 1 → 1 → 1

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Approach
--------
- Use dynamic programming:
  dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
- Base case: start at (0,0) with grid[0][0].
- Space optimization: use only 1D arrays (`prev` and `temp`).

Time:  O(m * n)
Space: O(n)
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int up = i > 0 ? prev[j] : Integer.MAX_VALUE;
                    int left = j > 0 ? temp[j - 1] : Integer.MAX_VALUE;
                    temp[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}

