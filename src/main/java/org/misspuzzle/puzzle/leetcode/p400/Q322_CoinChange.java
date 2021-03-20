package org.misspuzzle.puzzle.leetcode.p400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q322_CoinChange {
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] > 0) {
                for (int coin : coins) {
                    int newIndex = i + coin;

                    if (newIndex > 0 && newIndex <= amount) {
                        if (dp[newIndex] == 0) {
                            dp[newIndex] = dp[i] + 1;
                        } else {
                            dp[newIndex] = Math.min(dp[i] + 1, dp[newIndex]);
                        }
                    }
                }
            }
        }

        if (dp[amount] == 0) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int coin : coins) {
            set.add(coin);
        }

        return dp(set, amount, new HashMap<>());
    }

    private int dp(Set<Integer> coins, int amount, Map<Integer, Integer> cache) {
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        } else if (coins.contains(amount)) {
            return 1;
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin > 0) {
                int newCount = dp(coins, amount - coin, cache);

                if (newCount != -1) {
                    minCount = Math.min(minCount, newCount);
                }
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }

        minCount++;

        cache.put(amount, minCount);
        return minCount;
    }
}
