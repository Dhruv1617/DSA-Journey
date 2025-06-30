/*
LeetCode #875: Koko Eating Bananas
https://leetcode.com/problems/koko-eating-bananas/

Medium | Binary Search, Greedy

Time Complexity: O(n * log m), where:
    - n = number of piles
    - m = max value in piles[] (i.e., possible max speed Koko can eat)
Space Complexity: O(1)

Approach:
- Use binary search on the range of eating speeds (1 to max pile size).
- For each speed, calculate total hours required.
- If she can eat all bananas in <= h hours, try smaller speed (left side).
- Else, try higher speeds (right side).
*/



class Solution {
    
    public int findMax(int[] piles) {
        int ele = piles[0];
        for (int e : piles) {
            ele = Math.max(e, ele);
        }
        return ele;
    }

    public int totalHour(int[] piles, int k) {
        int t = 0;
        for (int i : piles) {
            t += Math.ceil((double)i / (double)k);
        }
        return t;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxEle = findMax(piles);
        
        int low = 1, high = maxEle;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (totalHour(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
