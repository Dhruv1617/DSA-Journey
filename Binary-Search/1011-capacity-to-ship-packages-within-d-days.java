/*
LeetCode #1011: Capacity to Ship Packages Within D Days
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

Medium | Binary Search, Greedy

Time Complexity: O(n · log S)  
    n  = weights.length  
    S  = (sum(weights) − max(weights)) (search range width)  
Space Complexity: O(1)

Approach
--------
1.  The larger the ship capacity, the fewer days we need.  
    ⇒ The days‑needed function is **monotonically non‑increasing**, so we can
    binary‑search the minimal feasible capacity.
2.  **Lower bound** = max weight in the array  
    (you must at least carry the heaviest package).  
    **Upper bound** = sum of all weights  
    (capacity big enough to ship all in one day).
3.  For a candidate capacity `mid`, scan the array once to compute how many days
    it would take (`findDays`).  
4.  If `daysNeeded ≤ D`, try a smaller capacity (search left); otherwise try
    a larger capacity (search right).
*/

class Solution {

    /** Returns the heaviest package weight (lower bound for capacity). */
    private int maxWeight(int[] weights) {
        int max = weights[0];
        for (int w : weights) max = Math.max(max, w);
        return max;
    }

    /** Given a capacity, return how many days are needed to ship all packages. */
    private int daysNeeded(int[] weights, int cap) {
        int days = 1, load = 0;
        for (int w : weights) {
            if (load + w > cap) {   // start a new day
                days++;
                load = w;
            } else {
                load += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int D) {
        int low  = maxWeight(weights);      // minimum feasible capacity
        int high = 0;                       // maximum = sum of all weights
        for (int w : weights) high += w;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (daysNeeded(weights, mid) <= D) {
                high = mid - 1;             // feasible, try smaller
            } else {
                low = mid + 1;              // infeasible, need bigger ship
            }
        }
        return low;                         // smallest feasible capacity
    }
}

