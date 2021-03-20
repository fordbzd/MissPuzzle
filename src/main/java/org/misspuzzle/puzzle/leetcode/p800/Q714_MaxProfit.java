package org.misspuzzle.puzzle.leetcode.p800;

public class Q714_MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int buy = -100000;

        for (int i = 0; i < prices.length; i++) {
            int oldSell = sell;

            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, oldSell - prices[i]);
        }

        return sell;
    }
}
