class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        output = 0
        l = 0
        r = 1
        while (r < len(prices)):
            if (prices[l] < prices[r]):
                output = max(output, prices[r]-prices[l])
            else:
                l = r
            r+=1
        return output