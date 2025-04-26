/*
LeetCode #169: Majority Element
https://leetcode.com/problems/majority-element/

Easy | Array, Hash Table, Divide and Conquer, Sorting, Counting

Time: O(n)
Space: O(1)

Approach:
- Use Boyer-Moore Voting Algorithm.
- Keep a count and a candidate element.
- If count is zero, pick the current element as a candidate.
- Increase or decrease count based on whether current element matches the candidate.
- Since a majority element is guaranteed to exist, the candidate at the end is the answer.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = -1;
        for(int i = 0;i<nums.length;i++){
            if(count==0){
                count = 1;
                ele = nums[i];
            }
            else if(ele == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
}
