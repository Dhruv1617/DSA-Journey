/*
LeetCode #1283: Find the Smallest Divisor Given a Threshold
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

Medium | Binary Search, Math

Time Complexity: O(n · log M)  
    n = nums.length  
    M = max(nums) (search range 1 … M)  
Space Complexity: O(1)

Approach
--------
1.  The larger the divisor, the smaller each ⌈nums[i]/div⌉ becomes, so the total
    sum is **monotonically non‑increasing** as the divisor grows.  
    ⇒ We can binary‑search on the divisor.
2.  Search bounds: **low = 1**, **high = max(nums)**.  
3.  For a candidate divisor `mid`, compute  
    `sum = Σ ⌈nums[i] / mid⌉`.  
    • If `sum > threshold`, the divisor is too small ⇒ move `low` right.  
    • Otherwise, it’s feasible ⇒ shrink to smaller divisors by moving `high` left.  
4.  The loop ends with `low` at the minimum feasible divisor.
*/

class Solution {

    private int maxElement(int[] nums) {
        int max = nums[0];
        for (int x : nums) max = Math.max(max, x);
        return max;
    }

    /** Returns Σ ⌈nums[i] / div⌉ for a given divisor. */
    private int sumWithDivisor(int[] nums, int div) {
        int sum = 0;
        for (int x : nums) {
            sum += (x + div - 1) / div;   // integer ceil without casting to double
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = maxElement(nums);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumWithDivisor(nums, mid) > threshold) {
                low = mid + 1;            // divisor too small, need larger
            } else {
                high = mid - 1;           // feasible, try smaller divisor
            }
        }
        return low;                       // min feasible divisor
    }
}
