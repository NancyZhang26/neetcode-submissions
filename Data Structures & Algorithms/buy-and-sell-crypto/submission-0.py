class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        output = 0
        for i in range(0, len(prices)):
            for j in range(i+1, len(prices)):
                if prices[j]>prices[i]:
                    output = max(output, prices[j]-prices[i])

        return output