package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class BestTimetoBuyandSellStock {

    //121. Best Time to Buy and Sell Stock
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit2(int[] prices) {
        int max=0 ;
        for(int i=0 ; i<prices.length; i++)
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]>prices[i])
                    max = Math.max(max, prices[j]-prices[i]);
            }
        return max;
    }
}
