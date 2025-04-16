/*
LeetCode #11: Container With Most Water
https://leetcode.com/problems/container-with-most-water/

Medium | Two Pointers | Greedy

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = 0;
        while(left<right){
            int minHeight = Math.min(height[left],height[right]);
            int width = right-left;
            int water = minHeight*width;
            maxWater = Math.max(maxWater, water);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}

