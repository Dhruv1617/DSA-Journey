/*
LeetCode #63: Unique Paths II
https://leetcode.com/problems/unique-paths-ii/

Medium | Dynamic Programming

Problem
-------
A robot is located at the top-left corner of an m x n grid. 
- The robot can only move right or down.
- Some cells are blocked (obstacles = 1).
- The robot cannot step on obstacles.
- Return the number of unique paths to reach the bottom-right.

Constraints
-----------
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1
Answer <= 2 * 10^9

Examples
--------
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Approach
--------
- Use dynamic programming:
  dp[i][j] = dp[i-1][j] + dp[i][j-1], if no obstacle
  dp[i][j] = 0, if obstacle
- Space optimization: only keep one row (`prev`) and current row (`temp`).

Time:  O(m * n)
Space: O(n)
*/


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0; // obstacle, no path
                } else if (i == 0 && j == 0) {
                    temp[j] = 1; // starting point
                } else {
                    int up = i > 0 ? prev[j] : 0;
                    int left = j > 0 ? temp[j - 1] : 0;
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}

