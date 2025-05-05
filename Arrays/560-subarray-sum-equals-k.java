/*
LeetCode #560: Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/

Medium | Array, Hash Map, Prefix Sum

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
- Use a prefix sum and a HashMap to store the count of prefix sums seen so far.
- At each index, calculate the current prefix sum.
- Check if (prefix sum - k) has been seen before.
  If it has, the number of times it has been seen is the number of valid subarrays ending at the current index.
- Update the map with the current prefix sum.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        map.put((long)0, 1);
        for(int i = 0;i<n;i++){
            sum+=nums[i];
           
            long rem = sum-k;
            count+=map.getOrDefault(rem , 0);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
