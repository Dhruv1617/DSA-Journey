/*
LeetCode #75: Sort Colors
https://leetcode.com/problems/sort-colors/

Medium | Array, Three Pointers, Sorting

Time: O(n)
Space: O(1)

Approach:
- Use three pointers (low, mid, high).
- Move 0s to the front, 2s to the back, and 1s stay in the middle.
- Solve it in a single pass without using library sort functions.
*/

class Solution {
    public static void swap(int[] nums, int n1, int n2){
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,mid, low);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
