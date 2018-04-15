package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class BestTimetoBuyandSellStock2 {

    //122. Best Time to Buy and Sell Stock II
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0, current = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += (prices[i - 1] - current);
                current = prices[i];
            } else if (i == prices.length - 1) {
                profit += prices[i] - current;
            }
        }
        return profit;
    }
}
