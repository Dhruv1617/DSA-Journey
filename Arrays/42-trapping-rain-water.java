/*
LeetCode #42: Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/

Hard | Array | Two Pointers | Stack | Dynamic Programming

Time: O(n)
Space: O(n)
*/


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int water = 0;

        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        for(int i = 0; i < n; i++){
            water += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return water;
    }
}
