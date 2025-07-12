/*
LeetCode #1539: Kth Missing Positive Number
https://leetcode.com/problems/kth-missing-positive-number/

Easy | Array, Binary Search

Time Complexity: O(log n)  
Space Complexity: O(1)

Key Insight
-----------
For a strictly increasing array `arr`, the number of missing positives up to
index `i` is:
        missing(i) = arr[i] − (i + 1)

This value is **monotonically non‑decreasing**, so we can binary‑search for the
smallest index where `missing(i) ≥ k`.

After the loop, `high` is at the last index where `missing < k`, and the kth
missing number is:
        answer = (high + 1) + k
*/


class Solution {

    /** Binary‑search helper: returns kth missing positive number. */
    private int kthMissing(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;      // need to skip further to the right
            } else {
                high = mid - 1;     // kth missing is to the left (or at mid)
            }
        }

        // high == last index where missing < k
        // answer = (#numbers accounted for) + (#still missing)
        return (high + 1) + k;
    }

    public int findKthPositive(int[] arr, int k) {
        return kthMissing(arr, k);
    }
}
