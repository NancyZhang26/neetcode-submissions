class Solution {
    public int maxProfit(int[] prices) {
        int output = 0;
        int l = 0; int r = 1;
        while (r < prices.length) {
            if (prices[l]<prices[r]) {
                output = Math.max(output, prices[r]-prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return output;
    }
}
