/*
LeetCode #121: Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Easy | Array, Dynamic Programming

Time: O(n)
Space: O(1)

Approach:
- Track the minimum price seen so far while traversing.
- At each step, calculate the profit if selling today.
- Update the maximum profit if the current profit is greater.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min =Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(min, prices[i]);
            max  = Math.max(prices[i]-min, max);
        }
        return max;
    }

}
