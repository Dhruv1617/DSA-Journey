/*
LeetCode #1: Two Sum
https://leetcode.com/problems/two-sum/

Easy | Array | HashMap

Time: O(n)
Space: O(n)

Approach:
- Use a HashMap to store the complement (target - nums[i]) and its index.
- If the current number is already in the map, return the pair of indices.
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int leftTarget = target - nums[i];
            if(map.containsKey(leftTarget)){
                return new int[]{map.get(leftTarget),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
