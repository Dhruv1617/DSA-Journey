/*
LeetCode #120: Triangle
https://leetcode.com/problems/triangle/

Medium | Dynamic Programming

Problem
-------
Given a triangle array, return the minimum path sum from top to bottom.

Each step you may move to an adjacent number of the row below. 
If you are at index i in the current row, you can move to index i or i+1 
in the next row.

Constraints
-----------
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == i + 1
-10^4 <= triangle[i][j] <= 10^4

Examples
--------
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The path is 2 → 3 → 5 → 1 = 11

Input: triangle = [[-10]]
Output: -10

Approach
--------
- Use bottom-up dynamic programming.
- Start from the last row, initialize `front` with its values.
- For each row above:
  dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])
- Space optimized using 1D arrays (`front` and `curr`).

Time:  O(n^2)
Space: O(n)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Initialize with last row
        int[] front = new int[n];
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + front[j];
                int diag = triangle.get(i).get(j) + front[j + 1];
                curr[j] = Math.min(down, diag);
            }
            front = curr;
        }

        return front[0];
    }
}

