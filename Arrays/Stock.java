
//problem - (121)https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Topic - arrays
//Level - easy

//Given an array prices where prices[i] is the price of a given stock on the ith day, return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//at each step in an array find the minimum element (if the element is minimum then fine )else calculate the profit i.e selling on a day with more price
//Time complexity - O(n)

public class Stock {

    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            } else {
                int profit = prices[i] - minSoFar;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}


