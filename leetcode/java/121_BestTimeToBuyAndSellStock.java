// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        int ans = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxVal = Math.max(maxVal, prices[i]);
            ans = Math.max(ans, maxVal - prices[i]);
        }
        return ans;
    }
}
