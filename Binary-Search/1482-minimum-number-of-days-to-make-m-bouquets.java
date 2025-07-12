/*
LeetCode #1482: Minimum Number of Days to Make m Bouquets
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

Medium | Binary Search, Greedy | 2020‑present

Time Complexity:  O(n · log D)  
    n = bloomDay.length  
    D = (max bloom day − min bloom day)  
Space Complexity: O(1)

Approach
--------
1.  **Binary‑search** the answer on the day range [min(bloomDay), max(bloomDay)].  
2.  For a candidate day `mid`, use a single pass to test if we can form at least `m`
    bouquets of size `k` with flowers that have bloomed (`bloomDay[i] ≤ mid`).  
3.  If possible, search the **left half** (smaller days); otherwise search the
    **right half**.  
4.  Return the smallest day that passes the feasibility check.

Helper functions
----------------
- `findMin` / `findMax` → obtain search bounds.  
- `possible(day)` → greedy scan counting consecutive bloomed flowers and
  converting every `k` of them into one bouquet.
*/

class Solution {

    private int findMin(int[] arr) {
        int mini = Integer.MAX_VALUE;
        for (int x : arr) mini = Math.min(mini, x);
        return mini;
    }

    private int findMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int x : arr) maxi = Math.max(maxi, x);
        return maxi;
    }

    /** Returns true if we can build ≥ m bouquets of size k by `day`. */
    private boolean possible(int[] arr, int day, int m, int k) {
        int consec = 0, bouquets = 0;
        for (int val : arr) {
            if (val <= day) {
                if (++consec == k) {           // one bouquet completed
                    bouquets++;
                    consec = 0;
                }
            } else {
                consec = 0;                     // reset streak
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;   // impossible

        int low = findMin(bloomDay), high = findMax(bloomDay);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;                 // try smaller day
            } else {
                low = mid + 1;                  // need more days
            }
        }
        return low;
    }
}
